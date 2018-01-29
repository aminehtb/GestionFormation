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
    public ArrayList<keywords> findByformationId(int id) {
             try {
            
            ArrayList<keywords> keywords=new ArrayList<>();
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM keywords where formation_id="+id;
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next()){
                
                keywords key=new keywords(rs.getInt("id"), rs.getString("mot"), rs.getInt("formation_id"));
               
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
            String sql="SELECT * FROM keywords ";
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next()){
                
                keywords key=new keywords(rs.getInt("id"), rs.getString("mot"), rs.getInt("formation_id"));
                for (int i = 0; i < all.length; i++) {
                    if(key.getMot().toLowerCase().contains(all[i].toLowerCase())){
                        formationDaoDB db=new formationDaoDB();
                        formation f=db.findById(key.getFormation_id());
                        formations.add(f);
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
            String sql = "INSERT INTO `keywords`( `mot`, `formation_id`) VALUES ('" + k.getMot() + "'," + k.getFormation_id()+")";

            int rs = stmt.executeUpdate(sql);

            if (rs != 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return false;
    }
    
}
