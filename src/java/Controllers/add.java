/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import connection.categoryDB;
import connection.formationDaoDB;
import connection.keywordsDb;
import connection.niveauDB;
import connection.programDB;
import connection.sessionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.formation;
import models.keywords;
import models.program;

/**
 *
 * @author amine
 */
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int idx = -1;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set the niveau list and categories and session
        //Ssend them to UI
        //check post
        admin a = (admin) request.getSession().getAttribute("admin");
        if (a != null) {
            sessionDB session_db = new sessionDB();
            categoryDB category_db = new categoryDB();
            niveauDB niveau_db = new niveauDB();
            request.setAttribute("sessions", session_db.findAll());
            request.setAttribute("categories", category_db.findAll());
            request.setAttribute("niveaus", niveau_db.findAll());
            request.getRequestDispatcher("admin/add.jsp").forward(request, response);
        } else {
            response.sendRedirect("admin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data from 1 then create the formation
        //takes you to fill an keyword list which
        admin a = (admin) request.getSession().getAttribute("admin");
        if (a != null) {
            String loc = request.getParameter("location");
            String sub = request.getParameter("submit");
            if (request.getParameter("formation_id") != null) {
                System.out.println("formation_id : " + request.getParameter("formation_id"));
                idx = Integer.parseInt(request.getParameter("formation_id"));
            }

            System.out.println("id " + idx);

            programDB pdb = new programDB();
            formationDaoDB fdb = new formationDaoDB();
            keywordsDb kdb = new keywordsDb();

            if (loc.equals("formation")) {

                Map<String, String[]> map = request.getParameterMap();
                formation f = new formation();
                System.out.println("nom : " + map.get("name")[0]);
                f.setNom(map.get("name")[0]);
                f.setPrice(map.get("price")[0]);
                f.setDescription(map.get("description")[0]);
                //discount
                f.setDiscount(0);

                f.setNbr_heurs(Integer.parseInt(map.get("hours")[0]));
                f.setPlaces(Integer.parseInt(map.get("places")[0]));
                f.setCategory_id(Integer.parseInt(map.get("category")[0]));
                f.setNiveau_id(Integer.parseInt(map.get("niveau")[0]));
                f.setSession_id(Integer.parseInt(map.get("session")[0]));
                if (idx == -1) {
                    idx = fdb.addNewFormation(f);
                }
                if (idx != -1) {
                    f.setId(idx);
                    request.setAttribute("formation_id", f.getId());
                    request.setAttribute("place", "program");
                    this.doGet(request, response);
                } else {
                    response.sendRedirect("admin");
                }

            } else if (loc.equals("program")) {
                System.out.println("list Program" + pdb.findProgramByFormationId(idx));
                if (request.getParameter("submit").equals("single")) {
                    program p = new program(request.getParameter("nom"), request.getParameter("du"), request.getParameter("du"), request.getParameter("tache"), idx);
                    pdb.addNewProgram(p);
                    request.setAttribute("place", "program");
                }
                if (request.getParameter("submit").equals("all")) {

                    //set the location to send to keyword
                    request.setAttribute("place", "keyword");
                }
                request.setAttribute("programs", pdb.findProgramByFormationId(idx));
                request.setAttribute("formation_id", idx);
                this.doGet(request, response);
            } else if (loc.equals("keyword")) {
                System.out.println("from inside keyword iff " + request.getParameter("keys"));
                System.out.println("params name " + request.getParameterNames());
                String[] keywords = request.getParameter("keys").split(",");
                for (String keyword : keywords) {
                    //add keyword
                    keywords k = new keywords(keyword, idx);
                    kdb.addNewKeyword(k);
                }
                //send bak to admin 
                response.sendRedirect("adminHome");
            }

        } else {
            response.sendRedirect("admin");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
