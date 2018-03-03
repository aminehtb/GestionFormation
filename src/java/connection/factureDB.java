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
import models.admins;
import models.facture;
import models.panier;

/**
 *
 * @author amine
 */
public class factureDB {
    Statement stmt = null;
    Connection c = null;

    public ArrayList<facture> findAll() {
        ArrayList<facture> list=new ArrayList<>();
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `facture` ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                facture f=new facture(rs.getInt("user_id"), rs.getInt("formation_id"), rs.getString("montant"));
                list.add(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<facture> findByFormationId(int id) {
        ArrayList<facture> list=new ArrayList<>();
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `facture` where formation_id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                facture f=new facture(rs.getInt("user_id"), rs.getInt("formation_id"), rs.getString("montant"));
                list.add(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<facture> findByUserId(int id) {
        ArrayList<facture> list=new ArrayList<>();
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `facture` where user_id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                facture f=new facture(rs.getInt("user_id"), rs.getInt("formation_id"), rs.getString("montant"));
                list.add(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean addFacture(panier p,String montant){
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "INSERT INTO `facture`( `montant`,`user_id`, `formation_id`) VALUES ("+montant+"," + p.getUser_id() + "," + p.getFormation_id() + ")";

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
