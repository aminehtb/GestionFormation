/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import models.formation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amir
 */
public class formationDaoDB implements formationDAO {

    Statement stmt = null;
    Connection c = null;

    @Override
    public ArrayList<formation> findAll() {
        try {
            ArrayList<formation> list = new ArrayList<>();

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM formation";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                formation f=new formation(
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getString("price"),
                        rs.getInt("discount"),
                        rs.getInt("place"),
                        rs.getInt("nb_heur"),
                        rs.getInt("id"),
                        rs.getInt("niveau_id"),
                        rs.getInt("category_id"),
                        rs.getInt("session_id")
                );
              
                list.add(f);

            }
            rs.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(formationDaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<formation> findByCategory(int category) {
        try {
            ArrayList<formation> list = new ArrayList<>();

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM formation where category_id ="+category;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
               formation f=new formation(
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getString("price"),
                        rs.getInt("discount"),
                        rs.getInt("place"),
                        rs.getInt("nb_heur"),
                        rs.getInt("id"),
                        rs.getInt("niveau_id"),
                        rs.getInt("category_id"),
                        rs.getInt("session_id")
                );
                list.add(f);
            }
            rs.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(formationDaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public formation findById(int id) {
        try {
            ArrayList<formation> list = new ArrayList<>();

            c = maConnection.getInstance();
            stmt = c.createStatement();
            String sql = "SELECT * FROM formation where id="+id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                formation f=new formation(
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getString("price"),
                        rs.getInt("discount"),
                        rs.getInt("place"),
                        rs.getInt("nb_heur"),
                        rs.getInt("id"),
                        rs.getInt("niveau_id"),
                        rs.getInt("category_id"),
                        rs.getInt("session_id")
                );
              return f;

            }
        } catch (SQLException ex) {
            Logger.getLogger(formationDaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
