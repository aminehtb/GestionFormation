/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import connection.categoryDB;
import connection.formationDaoDB;
import connection.formationSessionDB;
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
import models.admins;

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
        admins a = (admins) request.getSession().getAttribute("admin");
        if (a != null) {
            sessionDB session_db = new sessionDB();
            categoryDB category_db = new categoryDB();
            niveauDB niveau_db = new niveauDB();
            keywordsDb kdb = new keywordsDb();
            request.setAttribute("sessions", session_db.findAll());
            request.setAttribute("categories", category_db.findAll());
            request.setAttribute("niveaus", niveau_db.findAll());
            request.setAttribute("keywords", kdb.findAll());
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
        
        //System.out.println(""+request.getParameterMap().get("session").length);
        admins a = (admins) request.getSession().getAttribute("admin");
        if (a != null) {
            String loc = request.getParameter("location");
            String sub = request.getParameter("submit");
            
            System.out.println("first of all :"+request.getServletContext().getAttribute("formation_id"));
            
            if (request.getServletContext().getAttribute("formation_id") != null) {
                System.out.println("formation_id : " + request.getServletContext().getAttribute("formation_id"));
                idx = Integer.parseInt(request.getServletContext().getAttribute("formation_id").toString());
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
                if (request.getServletContext().getAttribute("formation_id")==null) {
                    idx = fdb.addNewFormation(f);
                }
                if (idx != -1) {
                    f.setId(idx);
                    // add formation to sessions
                    formationSessionDB fsDB=new formationSessionDB();
                    for (int i = 0; i < map.get("session").length; i++) {
                        int session_id=Integer.parseInt(map.get("session")[i]);
                        fsDB.addFormationToSession(idx,session_id);
                        
                    }
                    
                    request.getServletContext().setAttribute("formation_id", f.getId());
                    request.setAttribute("place", "program");
                    this.doGet(request, response);
                } else {
                    response.sendRedirect("admin");
                }

            } else if (loc.equals("program")) {
                System.out.println("list Program" + pdb.findProgramByFormationId(idx));
                if (request.getParameter("submit").equals("single")) {
                    program p = new program(request.getParameter("nom"), request.getParameter("du"), request.getParameter("au"), request.getParameter("tache"), idx);
                    pdb.addNewProgram(p);
                    request.setAttribute("place", "program");
                }
                if (request.getParameter("submit").equals("all")) {

                    //set the location to send to keyword
                    request.setAttribute("place", "keyword");
                }
                request.setAttribute("programs", pdb.findProgramByFormationId(idx));
                request.getServletContext().setAttribute("formation_id", idx);
                this.doGet(request, response);
            } else if (loc.equals("keyword")) {
                
                Map<String, String[]> map = request.getParameterMap();
                if(request.getParameter("action").equals("add keyword")){
                    System.out.println("add new keyword");
                    keywords k = new keywords(map.get("new_key")[0], idx);
                    kdb.addNewKeyword(k);
                    request.setAttribute("place", "keyword");
                    this.doGet(request, response);
                }
                if(request.getParameter("action").equals("next")){
                    if(map.get("keywords").length!=0){
                        for (int i = 0; i < map.get("keywords").length; i++) {
                            
                            int k_id=Integer.parseInt(map.get("keywords")[i]);
                            kdb.addExistKeyword(k_id, idx);
                        }
                    }
                    //test if something is selected and something in newkey
                    // then return to samepage 

                    request.getServletContext().removeAttribute("formation_id");
                    System.out.println("after remove :"+request.getServletContext().getAttribute("formation_id") );
                    //send bak to admin 
                    response.sendRedirect("adminHome");
                }
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
