/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.facture;
import models.panier;

/**
 *
 * @author amine
 */
public class factureDB {
    Statement stmt = null;
    Connection c = null;

    public ArrayList<facture> findAll(int id) {
        return null;
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
