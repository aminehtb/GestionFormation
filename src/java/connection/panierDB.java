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
import models.panier;

/**
 *
 * @author amine
 */
public class panierDB {

    Statement stmt = null;
    Connection c = null;

    public ArrayList<panier> findAll(int id) {
        try {

            ArrayList<panier> paniers = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM panier where user_id=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                panier p = new panier(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("formation_id"));

                paniers.add(p);
            }
            rs.close();
            return paniers;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
    }

    public boolean addFormationToPanier(panier p) {
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "INSERT INTO `panier`( `user_id`, `formation_id`) VALUES (" + p.getUser_id() + "," + p.getFormation_id() + ")";

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

    public ArrayList<formation> findAllFormation(int id) {
        try {

            ArrayList<formation> formation = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            ResultSet rs = null;
            ArrayList<panier> list = this.findAll(id);
            for (int i = 0; i < list.size(); i++) {
                String sql = "SELECT * FROM formation where id=" + list.get(i).getFormation_id();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    formation f = new formation(
                            rs.getString("nom"),
                            rs.getString("description"),
                            rs.getString("price"),
                            rs.getInt("discount"),
                            rs.getInt("place"),
                            rs.getInt("nb_heur"),
                            rs.getInt("id"),
                            rs.getInt("niveau_id"),
                            rs.getInt("category_id")
                    );

                    formation.add(f);
                }
            }
            return formation;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return null;
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
    
    public boolean formation_in_panier(int user_id,int formation_id) {
        try {

            ArrayList<panier> paniers = new ArrayList<>();
            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM panier where user_id="+user_id+" and formation_id="+formation_id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return true;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "msg !");
        }
        return false;
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
