/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.category;
import models.formation;
import models.keywords;
import models.program;

/**
 *
 * @author amine
 */
public class keywordsDb {
    Statement stmt = null; 
    Connection c=null;
    private Statement stmt1;
    
    public ArrayList<keywords> findAll() {
             try {
            
            ArrayList<keywords> keywords=new ArrayList<>();
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM keywords ";
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next()){
                
                keywords key=new keywords(rs.getInt("id"), rs.getString("mot"),0);
               
               keywords.add(key);
            }
            rs.close();
            return keywords;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return null;
    }
    
    public keywords findById(int id){
        try {
            
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM keywords where id="+id;
            ResultSet rs = stmt.executeQuery(sql);
      
            if(rs.next()){
                
                keywords key=new keywords(rs.getInt("id"), rs.getString("mot"), 0);
               
              return key;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return null;
    }
    public keywords findByMot(String mot){
        try {
            
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM keywords where mot='"+mot+"'";
            ResultSet rs = stmt.executeQuery(sql);
      
            if(rs.next()){
                
                keywords key=new keywords(rs.getInt("id"), rs.getString("mot"), 0);
               
              return key;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return null;
    }
    
    public ArrayList<keywords> findByformationId(int id) {
             try {
            
            ArrayList<keywords> keywords=new ArrayList<>();
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM formation_keyword where formation_id="+id;
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next()){
                
                keywords key=this.findById(rs.getInt("keyword_id"));
               
               keywords.add(key);
            }
            rs.close();
            return keywords;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return null;
    }
    
    public ArrayList<formation> searchFormation(String mot) {
        
        String[] all=mot.split(" ");
             try {
            
            ArrayList<formation> formations=new ArrayList<>();
            c=maConnection.getInstance();
            stmt = c.createStatement();
            stmt1 = c.createStatement();
            String sql="SELECT * FROM keywords ";
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next()){
                
                keywords key=new keywords(rs.getInt("id"), rs.getString("mot"),0);
                for (int i = 0; i < all.length; i++) {
                    if(key.getMot().toLowerCase().contains(all[i].toLowerCase())){
                        //if keyword exist then go find all formation related to it
                        String sql1="SELECT * FROM formation_keyword ";
                        ResultSet rs1 = stmt1.executeQuery(sql1);
                        formationDaoDB db=new formationDaoDB();
                        while(rs1.next()){
                        formation f=db.findById(rs1.getInt("formation_id"));
                        formations.add(f);
                           
                        }
                        
                        rs1.close();
                    }
                }
                
               
            }
            rs.close();
            return formations;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return null;
    }
    
    
    public boolean addNewKeyword(keywords k) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            System.out.println("   :   "+k.toString());
            String sql = "INSERT INTO `keywords`( `mot`) VALUES ('" + k.getMot() +"')";

            int rs = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet res = stmt.getGeneratedKeys();
            long productId=-1;
            if (res.next()) {
               productId= res.getLong(1);
               /*
                if(productId!=-1){
                    String sql1 = "INSERT INTO `formation_keyword`(  `formation_id`,`keyword_id`) VALUES ('" +  k.getFormation_id()+ "'," +productId+")";
                    int rs1=stmt.executeUpdate(sql1);
                    if(rs1!=0)
                        return true;
                }
                */
            }

        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return false;
    }
    
    public boolean addExistKeyword(int keyword_id,int formation_id) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql1 = "INSERT INTO `formation_keyword`(  `formation_id`,`keyword_id`) VALUES ('" + formation_id+ "'," +keyword_id+")";
            int rs1=stmt.executeUpdate(sql1);
            if(rs1!=0)
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return false;
    }
    
}
