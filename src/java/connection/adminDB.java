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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.admins;
import models.user;

/**
 *
 * @author amine
 */
public class adminDB {

    Statement stmt = null;
    Connection c = null;

    public admins validate(String u, String p) {
        admins ad = null;
        try {

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM `admins` where username= '" + u + "' and password = '" + p + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {

                ad = new admins(rs.getInt("id"), rs.getString("username"), rs.getString("password"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad;
    }
    
    

}
