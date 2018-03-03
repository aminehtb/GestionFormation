/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import connection.factureDB;
import connection.formationDaoDB;
import connection.panierDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.panier;
import models.user;

/**
 *
 * @author amine
 */
@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class checkout extends HttpServlet {

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
            out.println("<title>Servlet checkout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkout at " + request.getContextPath() + "</h1>");
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
            
        panierDB db=new panierDB();
        factureDB fdb= new factureDB();
        formationDaoDB for_db=new formationDaoDB();
        user usr=(user)request.getSession().getAttribute("user");
        String action=request.getParameter("action");
        String pk=request.getParameter("pk");
        if(usr!=null){
        panier p=db.getPanierById(usr.getId());
        
        if(action!=null && pk!=null){
            if (action.equals("d")) {
                //delete it from panier
                db.deleteFormationToPanier(Integer.parseInt(pk));
            }else if (action.equals("p")&&p!=null) {
                //pay it and genarate facture
                fdb.addFacture(p, for_db.findById(Integer.parseInt(pk)).getPrice());
                for_db.takePlace(Integer.parseInt(pk));
                db.deleteFormationToPanier(Integer.parseInt(pk));
                
            }
        }
        if(action!=null && action.equals("all")){
            ArrayList<panier> list_panier=db.findAll(usr.getId());
            for (int i = 0; i < list_panier.size(); i++) {
                panier obj=list_panier.get(i);
                fdb.addFacture(obj, for_db.findById(obj.getFormation_id()).getPrice());
                for_db.takePlace(obj.getFormation_id());
                db.deleteFormationToPanier(obj.getFormation_id());
            }
        }
        
        request.setAttribute("formation_panier", db.findAllFormation(usr.getId()));
        }
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
