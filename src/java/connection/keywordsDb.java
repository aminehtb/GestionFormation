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
import models.keywords;

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
    
}