package tn.esprit.models;

public class Reserver {

    private int id_Res;
    private String codeQR;
    private float prix_total;

    private Evenement Evenement;
    private User user;
    public Reserver() {
    }

    public Reserver(tn.esprit.models.Evenement evenement, User user, String codeQR) {
        Evenement = evenement;
        this.user = user;
        this.codeQR = codeQR;
        this.prix_total = prix_total;
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

    public tn.esprit.models.Evenement getEvenement() {
        return Evenement;
    }

    public void setEvenement(tn.esprit.models.Evenement evenement) {
        Evenement = evenement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
