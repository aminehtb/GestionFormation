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
import models.panier;
import models.program;

/**
 *
 * @author amine
 */
public class programDB {
    
    Statement stmt = null;
    Connection c = null;
    
    public ArrayList<program> findAll() {
        try {

            ArrayList<program> programs = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `program` ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                program p=new  program(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("du"),
                        rs.getString("au"),
                        rs.getString("tache"),
                        rs.getInt("formation_id")
                );

                programs.add(p);
            }
            rs.close();
            return programs;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }


    public ArrayList<program> findProgramByFormationId(int formation_id) {
        try {

            ArrayList<program> programs = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `program` where formation_id=" + formation_id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                program p=new  program(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("du"),
                        rs.getString("au"),
                        rs.getString("tache"),
                        rs.getInt("formation_id")
                );

                programs.add(p);
            }
            rs.close();
            return programs;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }

    public boolean addNewProgram(program p) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "INSERT INTO `program`(`titre`, `du`, `au`, `tache`, `formation_id`) VALUES ('" + p.getTitre() + "','" + p.getDu()+"','" + p.getAu()+ "','" + p.getTache()+"'," + p.getFormation_id()+")";

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
    
    public boolean updateProgram(int id,program p) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql="UPDATE `program` SET `titre`='" + p.getTitre() + "',`du`='" + p.getDu()+"',`au`='" + p.getAu()+ "',`tache`='" + p.getTache()+"' WHERE id="+id;
            

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
    public String getToatalPrice(int id) {
        try {

            ArrayList<panier> paniers = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            int totalPrice = 0;
            String sql = "SELECT * FROM panier where user_id=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                panier p = new panier(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("formation_id"));

                paniers.add(p);
            }
            formationDaoDB fdb = new formationDaoDB();
            for (int i = 0; i < paniers.size(); i++) {
                formation f = fdb.findById(paniers.get(i).getFormation_id());
                totalPrice += Integer.parseInt(f.getPrice());
            }
            rs.close();
            return "" + totalPrice;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }
    
    public panier getPanierById(int id) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM panier where user_id=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                panier p = new panier(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("formation_id"));

                return p;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }
    
     public boolean deleteFormationToPanier(int id) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "DELETE FROM `panier` WHERE formation_id="+id;

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
