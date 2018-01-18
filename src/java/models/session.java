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
public class session {

    private int id;
    private String nom, date_debut;

    public session(int id, String nom, String date_debut) {
        this.id = id;
        this.nom = nom;
        this.date_debut = date_debut;
    }

    public session() {
    }

    public session(String nom, String date_debut) {
        this.nom = nom;
        this.date_debut = date_debut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    @Override
    public String toString() {
        return "session{" + "id=" + id + ", nom=" + nom + ", date_debut=" + date_debut + '}';
    }

}
