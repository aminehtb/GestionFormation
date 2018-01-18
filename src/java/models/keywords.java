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
public class keywords {

    private int id, formation_id;
    private String mot;

    public keywords() {
    }

    public keywords(String mot, int formation_id) {
        this.mot = mot;
    }

    public keywords(int id, String mot, int formation_id) {
        this.id = id;
        this.mot = mot;
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

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    @Override
    public String toString() {
        return "keywords{" + "id=" + id + ", mot=" + mot + '}';
    }

}
