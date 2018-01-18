package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author amir
 */
public class user {

    private String password, firstname, lastname, phone, adress, email;
    private int id;

    public user(String email, String password, String firstname, String lastname, String phone, String adress,  int id) {
        
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.id = id;
    }

    public user(String email, String password, String firstname, String lastname, String phone, String adress) {
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
    }

    public user() {
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "user{" + " password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", adress=" + adress + ", email=" + email + ", id=" + id + '}';
    }

}
