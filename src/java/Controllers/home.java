/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import connection.categoryDB;
import models.formation;
import connection.formationDaoDB;
import connection.keywordsDb;
import connection.panierDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.keywords;
import models.panier;
import models.user;

/**
 *
 * @author amir
 */
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

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
        
        String  action=request.getParameter("add-cart");
        System.out.println(""+action);
        String[] slider=null;
        if(request.getParameter("slider")!=null)
            slider=request.getParameter("slider").split(",");
      
        //get all formations
        formationDaoDB db=new formationDaoDB();
        categoryDB catDB=new categoryDB();
        ArrayList<formation> formations =new ArrayList<>();
        String filter=request.getParameter("filter");
        request.setAttribute("filter", filter);
        //filtring if filter has category to fiter with
        if(filter==null)
                formations=db.findAll();
            else{
                formations=db.findByCategory(new categoryDB().getCategoryId(filter));
            }
        //filtring with price 
        if(slider!=null){
            formations=filterByPrice(formations,slider[0],slider[1]);
        }
   
        ArrayList<keywords> keywords_list=new ArrayList<keywords>();
        //getting keywords by looping trough all formations and then looping from all keywords taht matchs the formation id  
        for (int i = 0; i < formations.size(); i++) {
            ArrayList<keywords> res=new keywordsDb()
                    .findByformationId(
                            formations.get(i)
                                    .getId()
                    );
            for (int j = 0; j < res.size(); j++) {
                keywords_list.add(res.get(j));
            }
        
        }
        
        //panier 
        panierDB pandb=new panierDB();
        user usr=(user)request.getSession().getAttribute("user");
        if(action!=null){
            
            panier p=new panier(usr.getId(), db.findById(Integer.parseInt(action)).getId());
            pandb.addFormationToPanier(p);
        }
        if(request.getSession().getAttribute("user")!=null){
            
            ArrayList<panier> paniers=pandb.findAll(usr.getId());
            request.getSession().setAttribute("panier", paniers);
            request.getSession().setAttribute("totalPrice", pandb.getToatalPrice(usr.getId()));
            
           
        }
        //setting all attribute 
        request.setAttribute("formations", formations);
        request.setAttribute("categories", catDB.findAll());
        request.setAttribute("keywords", keywords_list);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    
    public ArrayList<formation> filterByPrice(ArrayList<formation> oldList,String min,String max){
        ArrayList<formation> newList=new ArrayList<>();
        for (int i = 0; i < oldList.size(); i++) {
            formation obj=oldList.get(i);
            if(Integer.parseInt(obj.getPrice())<=Integer.parseInt(max)
                    &&Integer.parseInt(obj.getPrice())>=Integer.parseInt(min))
                newList.add(obj);
        }
        return newList;
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
        processRequest(request, response);
        
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