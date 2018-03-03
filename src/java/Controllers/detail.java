package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import connection.formationDaoDB;
import connection.panierDB;
import connection.programDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.formation;
import models.panier;
import models.program;
import models.user;

/**
 *
 * @author amine
 */
@WebServlet(urlPatterns = {"/detail"})
public class detail extends HttpServlet {

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
            out.println("<title>Servlet detail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet detail at " + request.getContextPath() + "</h1>");
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
        int id=Integer.parseInt(request.getParameter("pk"));
        String action = request.getParameter("action");
        
        panierDB pandb=new panierDB();
        formationDaoDB db=new formationDaoDB();
        
        if(action!=null && action.equals("cart")){
            
            if(request.getSession().getAttribute("user")!=null){
                user usr=(user)request.getSession().getAttribute("user");

                panier p=new panier(usr.getId(), id);
                pandb.addFormationToPanier(p);

                ArrayList<panier> paniers=pandb.findAll(usr.getId());
                request.getSession().setAttribute("panier", paniers);
                request.getSession().setAttribute("totalPrice", pandb.getToatalPrice(usr.getId()));
            }else{
                response.sendRedirect("sign-in.jsp");
                return ;
            }

        }
        boolean res=false;
        if(request.getSession().getAttribute("user")!=null){
                user usr=(user)request.getSession().getAttribute("user");
                res=pandb.formation_in_panier(usr.getId(),id);
        }
        System.err.println(""+request.getSession().getAttribute("totalPrice"));
        formation f =db.findById(id);
        programDB pdb=new programDB();
        ArrayList<program> p =pdb.findProgramByFormationId(id);
        request.setAttribute("title", "Detail | Gestion formation");
        request.setAttribute("obj", f);
        request.setAttribute("prog", p);
        request.setAttribute("in_panier", res);
       
        request.getRequestDispatcher("detail.jsp").forward(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
