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
public class program {

    private int id, formation_id;
    private String titre, du, au, tache;

    public program() {
    }


    public program(String nom, String du, String au, String tache, int formation_id) {
        this.titre = nom;
        this.du = du;
        this.au = au;
        this.tache = tache;
        this.formation_id = formation_id;
    }

    public program(int id, String nom, String du, String au, String tache, int formation_id) {
        this.id = id;
        this.titre = nom;
        this.du = du;
        this.au = au;
        this.tache = tache;
        this.formation_id = formation_id;
    }
    public int getFormation_id() {
        return formation_id;
    }
    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public String getAu() {
        return au;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    @Override
    public String toString() {
        return "program{" + "id=" + id + ", nom=" + titre + ", du=" + du + ", au=" + au + ", tache=" + tache + '}';
    }

}
