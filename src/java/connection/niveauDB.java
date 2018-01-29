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
import models.niveau;
import models.session;

/**
 *
 * @author amine
 */
public class niveauDB {
    Statement stmt = null;
    Connection c = null;
    
    public ArrayList<niveau> findAll() {
        try {

            ArrayList<niveau> niveaus = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `niveau` ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                niveau n=new niveau(rs.getInt("id"),rs.getString("nom"));
                niveaus.add(n);
            }
            rs.close();
            return niveaus;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }
    
    public niveau findNiveauById(int id) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `niveau` where id=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                
                niveau n=new niveau(rs.getInt("id"),rs.getString("nom"));
           
                return n;
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }
}
