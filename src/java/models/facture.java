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
public class facture {

    private int id, user_id, formation_id;
    private String montant;

    public facture() {
    }

    public facture(int user_id, int formation_id, String montant) {
        this.user_id = user_id;
        this.formation_id = formation_id;
        this.montant = montant;
    }

    public facture(int id, int user_id, int formation_id, String montant) {
        this.id = id;
        this.user_id = user_id;
        this.formation_id = formation_id;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFormation_id() {
        return formation_id;
    }

    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "facture{" + "id=" + id + ", user_id=" + user_id + ", formation_id=" + formation_id + ", montant=" + montant + '}';
    }

}
