/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import connection.factureDB;
import connection.formationDaoDB;
import connection.userBd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.facture;
import models.formation;
import models.user;

/**
 *
 * @author amine
 */
@WebServlet(name = "listfacture", urlPatterns = {"/listfacture"})
public class listfacture extends HttpServlet {

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
            out.println("<title>Servlet listfacture</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listfacture at " + request.getContextPath() + "</h1>");
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
        String user_i = request.getParameter("user_i");
        String formation_i = request.getParameter("formation_i");
        
        
        ArrayList <formation> formations=new formationDaoDB().findAll();
        ArrayList <user> users=new userBd().findAll();
        ArrayList <facture> factures= new factureDB().findAll();
        
        if(formation_i!=null){
            try {
                factures=new factureDB().findByFormationId(Integer.parseInt(formation_i));
            } catch (Exception e) {
            }
            
        }
        if(user_i!=null){
            try {
                factures=new factureDB().findByUserId(Integer.parseInt(user_i));
            } catch (Exception e) {
            }
            
        }
        String[] tab_nom=new String[factures.size()];
        String[] tab_formation=new String[factures.size()];
        
        for (int i = 0; i < factures.size(); i++) {
            user u=new userBd().findByID(factures.get(i).getUser_id());
            formation f=new formationDaoDB().findById(factures.get(i).getFormation_id());
            tab_nom[i]=u.getFirstname();
            tab_formation[i]=f.getNom();
        }
        request.setAttribute("formation", tab_formation);
        request.setAttribute("nom", tab_nom);
        request.setAttribute("users", users);
        request.setAttribute("formations",formations );
        request.setAttribute("factures", factures);
        
                
        request.getRequestDispatcher("admin/facture.jsp").forward(request, response);
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
