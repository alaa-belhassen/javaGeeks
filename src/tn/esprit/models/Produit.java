package tn.esprit.models;

import java.sql.Blob;

public class Produit {

    private int idProduit;
    private String libelle;
    private int stocks;
    private float prix;
    private Blob photo;

    public Produit() {
    }

    public Produit(int idProduit, String libelle, int stocks, float prix, Blob photo) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.stocks = stocks;
        this.prix = prix;
        this.photo = photo;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }


}
