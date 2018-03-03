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
import models.program;
import models.session;

/**
 *
 * @author amine
 */
public class sessionDB {
    Statement stmt = null;
    Connection c = null;
    
    public ArrayList<session> findAll() {
        try {

            ArrayList<session> sessions = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `session` ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                session s=new session(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("date_debut"));
           
                sessions.add(s);
            }
            rs.close();
            return sessions;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }


    public session findSessionById(int id) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `session` where id=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                
                session s=new session(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("date_debut"));
           
                return s;
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }

    public boolean addNewSession(session s) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "INSERT INTO `session`(`nom`, `date_debut`) VALUES ('" + s.getNom() + "','" + s.getDate_debut()+"')";

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
    
    public boolean updateSession(int id,session s) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql="UPDATE `session` SET `nom`='" + s.getNom()+ "',`date_debut`='" + s.getDate_debut()+"' WHERE id="+id;
            

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
    public boolean deleteSession(int id) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql="DELETE FROM `session` WHERE id="+id;
            

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
