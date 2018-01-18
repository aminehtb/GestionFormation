package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amir
 */
public class maConnection {
    private static Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/gestionFormation?zeroDateTimeBehavior=convertToNull";
    private String username = "root";
    private String password = "toor";
    
   private maConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("database connection error : " + ex.getMessage());
        }
        
    }
   public static Connection getInstance()  {
      if(connection == null) {
          try {
              new maConnection();
          } catch (SQLException ex) {
              Logger.getLogger(maConnection.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return connection;
   }
   
}
