package tn.esprit.models;

import java.time.LocalDate;

public class Reserver {

    private int id_Res;
    private String codeQR;
    private float prix_total;

    private LocalDate date_res;
    private Evenement Evenement;
   private User user_id;

   private String status;
    public Reserver() {
    }

    public Reserver(tn.esprit.models.Evenement evenement, User user, String codeQR,LocalDate date,String status) {
        Evenement = evenement;
        this.user_id = user;
        this.codeQR = codeQR;
        this.prix_total = prix_total;
        this.date_res=date;
        this.status=status;
    }

    public LocalDate getDate() {
        return date_res;
    }

    public void setDate(LocalDate date) {
        this.date_res = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_Res() {
        return id_Res;
    }

    public void setId_Res(int id_Res) {
        this.id_Res = id_Res;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public Evenement getEvenement() {
        return Evenement;
    }

    public void setEvenement(tn.esprit.models.Evenement evenement) {
        Evenement = evenement;
    }

    public User getUser() {
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user;
    }
}
