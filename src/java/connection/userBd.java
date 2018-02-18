package connection;


import models.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class userBd {
    Statement stmt = null; 
    Connection c=null;
   
    public user validate(String u,String p) {
        user user=null;
        try {
            
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM users where email= '"+u+"' and password = '"+p+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                
                user=new user(
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phone"),
                        rs.getString("adress"),
                       rs.getInt("id")
               );
                System.out.println(user.toString());
                System.out.println("amine");
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public ArrayList<user> findAll() {
             try {
            
            ArrayList<user> users=new ArrayList<>();
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next()){
               user u=new user(
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phone"),
                        rs.getString("adress"),
                       rs.getInt("id")
               );
               users.add(u);
            }
            rs.close();
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"msg !");
        }
        return null;
    }


    public boolean insert(String u, String p,String fn,String ln,String phone,String adress) {
        boolean rs=false;
        try {
            c=maConnection.getInstance();
            stmt = c.createStatement();
            
            String sql="INSERT INTO users(email,password,firstname,lastname,phone,adress) VALUES('"+u+"','"+p+"','"+fn+"','"+ln+"','"+phone+"','"+adress+"')";
            int id = stmt.executeUpdate(sql);
            if(id!=-1)
                rs=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int update(int id, user u) {
        int rs=-5;
        try {
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql1="UPDATE users SET email='"+u.getEmail()
                    +"',password='"+u.getPassword()
                    +"',firstname='"+u.getFirstname()
                    +"',lastname='"+u.getLastname()
                    +"',phone='"+u.getPhone()
                    +"',adress='"+u.getAdress()+"' WHERE id="+id;
            rs = stmt.executeUpdate(sql1);
  
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }


    public void delete(int id) {
        try {
            c=maConnection.getInstance();
            stmt = c.createStatement();
            
            String sql="DELETE FROM users WHERE id="+id;
            int rs = stmt.executeUpdate(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public user findByID(int id) {
        user user=null;
        try {
            
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM users where id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                   user u=new user(
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phone"),
                        rs.getString("adress"),
                       rs.getInt("id")
               );
              
               return u;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
     public boolean findByEmail(String email) {
        user user=null;
        try {
            
            c=maConnection.getInstance();
            stmt = c.createStatement();
            String sql="SELECT * FROM users where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                   return true;
              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
