/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import connection.categoryDB;
import connection.formationDaoDB;
import connection.sessionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.admins;

/**
 *
 * @author amine
 */
@WebServlet(name = "home_admin", urlPatterns = {"/adminHome"})
public class home_admin extends HttpServlet {

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
            out.println("<title>Servlet home_admin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet home_admin at " + request.getContextPath() + "</h1>");
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
        admins a = (admins) request.getSession().getAttribute("admin");
        if (a != null) {
            
            String type   = request.getParameter("type");
            String id     = request.getParameter("id");
            String action = request.getParameter("action");
            
            if(type!=null && id !=null && action!=null){
                //delete
                if(action.equals("delete")){
                    if(type.equals("ses")){
                        //delete session
                        sessionDB db=new sessionDB();
                        db.deleteSession(Integer.parseInt(id));
                        
                        
                    }
                    else if(type.equals("cat")){
                        //delete category
                        categoryDB db=new categoryDB();
                        db.deleteCategory(Integer.parseInt(id));
                        
                        
                    }else if(type.equals("for")){
                        //delete formation
                        formationDaoDB db=new formationDaoDB();
                        db.deleteformation(Integer.parseInt(id));
                        
                    }
                }else if(action.equals("edit")){
                    if(type.equals("ses")){
                        //update session
                        
                        response.sendRedirect("addSession?id="+id);
                        return;
                        
                    }
                    else if(type.equals("cat")){
                        //delete category
                        response.sendRedirect("addCategory?id="+id);
                        return;
                        
                        
                    }else if(type.equals("for")){
                        //delete formation
                        formationDaoDB db=new formationDaoDB();
                        db.deleteformation(Integer.parseInt(id));
                        
                    }
                }
            }
            formationDaoDB db = new formationDaoDB();
            ArrayList formations = new ArrayList();
            formations = db.findAll();
            request.setAttribute("formations", formations);
            request.setAttribute("categories", new categoryDB().findAll());
            request.setAttribute("sessions", new sessionDB().findAll());
            request.getRequestDispatcher("admin/home.jsp").forward(request, response);
        } else {
            response.sendRedirect("admin");
        }
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
        //request.getRequestDispatcher("admin/listFormation.jsp").forward(request, response);

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
