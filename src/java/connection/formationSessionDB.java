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
import models.formation;
import models.session;

/**
 *
 * @author amine
 */
public class formationSessionDB {
    
    Statement stmt = null;
    Connection c = null;
    
    public void addFormationToSession(int formation_id,int session_id){
        
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "INSERT INTO `formation_session`( `formation_id`, `session_id`) VALUES ("+formation_id+","+session_id+")";

            stmt.executeUpdate(sql);
            
                
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
    }
    
    public ArrayList<formation>  getAllFormationBySession(int session_id){
        ArrayList<formation> list=new ArrayList<>();
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT  * FROM `formation_session` WHERE session_id="+session_id;

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int formation_id=Integer.parseInt(rs.getString("formation_id"));
                formationDaoDB db=new formationDaoDB();
                
                formation f=db.findById(formation_id);
                list.add(f);
            }
            return list;
                
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }
    public ArrayList<session>  getAllSessionByFormation(int formation_id){
        ArrayList<session> list=new ArrayList<>();
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT  * FROM `formation_session` WHERE formation_id="+formation_id;

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int session_id=Integer.parseInt(rs.getString("session_id"));
                sessionDB db=new sessionDB();
                
                session s=db.findSessionById(session_id);
                list.add(s);
            }
            return list;
                
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }
    
}
