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
import connection.sessionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.keywords;
import models.panier;
import models.session;
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
        String  mot=request.getParameter("search");
        String selectedPage=request.getParameter("selectedPage");

        
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
                formations=db.findByCategory(new categoryDB().findCategoryId(filter));
            }
        //filtring with price 
        if(slider!=null){
            formations=filterByPrice(formations,slider[0],slider[1]);
        }
        //search
        if(mot!=null){
            //seaarch bjy keywords
            ArrayList<formation> res_keywords=new keywordsDb().searchFormation(mot);
            //search by name
            ArrayList<formation> res_name=searchByName(formations, mot);
            //search in description
            ArrayList<formation> res_Description=searchByDescription(formations, mot);
            //concate
            formations=concatLists(res_keywords,res_Description,res_name);
        }
        //pagination 
        int itemPerPage=3;
        int numpage=1;
        List<formation> list=new ArrayList<formation>();
        if(formations.size()<itemPerPage){
            numpage=1;
            list=formations;
        }else{
        if(formations.size()%itemPerPage==0)
                numpage=formations.size()/itemPerPage;
        else
                numpage=(formations.size()/itemPerPage)+1;
        
        //creating sublist from all fomations
        
        int slected=0;
        if(selectedPage!=null){
            slected=Integer.parseInt(selectedPage)-1;
            System.out.println("selected :"+selectedPage);
        }
        
        if(slected<numpage){
                list=formations.subList(itemPerPage*slected,itemPerPage*slected+itemPerPage);
            }
            if (slected+1==numpage){ 
                list=formations.subList(itemPerPage*slected,formations.size());
            }
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
                
                if(!keywordExist(keywords_list,res.get(j)))
                    keywords_list.add((keywords)res.get(j));
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
        request.setAttribute("numpage", numpage);
        request.setAttribute("search", mot);
        request.setAttribute("title", "Home | Gestion formation");
        request.setAttribute("formations", list);
        request.getSession().setAttribute("categories", catDB.findAll());
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
    
    public boolean keywordExist(ArrayList<keywords> list,keywords k){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getMot().equals(k.getMot()))
                return true;
        }
        return false;
    }
    
    public boolean formationExist(ArrayList<formation> list,formation f){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==f.getId())
                return true;
        }
        return false;
    }
    public ArrayList<formation> searchByName(ArrayList<formation> list,String s){
        ArrayList<formation> res=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            formation f=list.get(i);
            if(f.getNom().contains(s)){
                res.add(f);
            }
        }
        
        return res;
    }
    
    public ArrayList<formation> searchByDescription(ArrayList<formation> list,String s){
        ArrayList<formation> res=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            formation f=list.get(i);
            if(f.getDescription().contains(s)){
                res.add(f);
            }
        }
        
        return res;
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

    private ArrayList<formation> concatLists(ArrayList<formation> res_keywords, ArrayList<formation> res_Description, ArrayList<formation> res_name) {
        ArrayList<formation> res=new ArrayList<>();
        
        for (int i = 0; i < res_Description.size(); i++) {
            if(!formationExist(res, res_Description.get(i)))
                res.add(res_Description.get(i));
        }
        
        for (int i = 0; i < res_keywords.size(); i++) {
            if(!formationExist(res, res_keywords.get(i)))
                res.add(res_keywords.get(i));
        }
        
        for (int i = 0; i < res_name.size(); i++) {
            if(!formationExist(res, res_name.get(i)))
                res.add(res_name.get(i));
        }
        System.out.println("name :"+res_name);
        System.out.println("des :"+res_Description);
        System.out.println("key :"+res_keywords);
        System.out.println("res :"+res);
        
        return res;
    }

}
