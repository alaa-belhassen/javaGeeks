package tn.esprit.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Evenement {

    private int idEvenement;
    private String lieu;
    private int max_places;
    private float prix;
    private String libelle;
    private Date date_event;
    private Timestamp time_event;
    private int duration;
    private String  status;



    //add fields
    private Reserver reserver;


    public Evenement() {
    }

    public Evenement(int idEvenement, String lieu, int max_places, float prix, String libelle, Date date_event, Timestamp time_event, int duration, Reserver reserver) {
        this.idEvenement = idEvenement;
        this.lieu = lieu;
        this.max_places = max_places;
        this.prix = prix;
        this.libelle = libelle;
        this.date_event = date_event;
        this.time_event = time_event;
        this.duration = duration;
        this.reserver = reserver;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getMax_places() {
        return max_places;
    }

    public void setMax_places(int max_places) {
        this.max_places = max_places;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public Timestamp getTime_event() {
        return time_event;
    }

    public void setTime_event(Timestamp time_event) {
        this.time_event = time_event;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Reserver getReserver() {
        return reserver;
    }

    public void setReserver(Reserver reserver) {
        this.reserver = reserver;
    }
}
