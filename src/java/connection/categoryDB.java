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

/**
 *
 * @author amine
 */
public class categoryDB {
    Statement stmt = null; 
    Connection c=null;
    public ArrayList<category> findAll() {
             try {
            
            ArrayList<category> categories=new ArrayList<>();
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM category";
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next()){
                category category=new category(rs.getInt("id"), rs.getString("nom"));
               
               categories.add(category);
            }
            rs.close();
            return categories;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return null;
    }
    public int findCategoryId(String nom){
         try {
            
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM category where nom="+nom+"";
            ResultSet rs = stmt.executeQuery(sql);
      
            if(rs.next()){
                return rs.getInt("id");
               
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return -1;
    }
}
