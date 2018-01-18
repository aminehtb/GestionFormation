/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author amir
 */
public class panier {

    private int id, user_id, formation_id;

    public panier() {
    }

    public panier(int user_id, int formation_id) {
        this.formation_id = formation_id;
        this.user_id = user_id;
    }

    public panier(int id, int user_id, int formation_id) {
        this.id = id;
        this.formation_id = formation_id;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormation_id() {
        return formation_id;
    }

    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }

    @Override
    public String toString() {
        return "panier{" + "id=" + id + ", formation_id=" + formation_id + '}';
    }

}
