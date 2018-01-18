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
public class formation {

    private String nom, description, price ;
    private int nbr_heurs,places,discount;
    private int id, niveau_id, category_id, session_id;

    public formation() {
    }

    public formation(String nom, String description, String price, int discount, int places, int nbr_heurs, int id, int niveau_id, int category_id, int session_id) {
        this.nom = nom;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.places = places;
        this.nbr_heurs = nbr_heurs;
        this.id = id;
        this.niveau_id = niveau_id;
        this.category_id = category_id;
        this.session_id = session_id;
    }

    public formation(String nom, String description, String price, int discount, int places, int nbr_heurs, int niveau_id, int category_id, int session_id) {
        this.nom = nom;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.places = places;
        this.nbr_heurs = nbr_heurs;
        this.niveau_id = niveau_id;
        this.category_id = category_id;
        this.session_id = session_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getNbr_heurs() {
        return nbr_heurs;
    }

    public void setNbr_heurs(int nbr_heurs) {
        this.nbr_heurs = nbr_heurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNiveau_id() {
        return niveau_id;
    }

    public void setNiveau_id(int niveau_id) {
        this.niveau_id = niveau_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }



    @Override
    public String toString() {
        return "formation{" + "nom=" + nom + ", description=" + description + ", price=" + price + ", discount=" + discount + ", places=" + places + ", nbr_heurs=" + nbr_heurs + ", id=" + id + ", niveau_id=" + niveau_id + ", category_id=" + category_id + ", session_id=" + session_id  + '}';
    }

}
