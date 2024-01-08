package tn.esprit.models;

public class Reserver {
    private Evenement Evenement;
    private User user;
    private String codeQR;
    private double prix;

    public Evenement getEvenement() {
        return Evenement;
    }

    public User getUser() {
        return user;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public double getPrix() {
        return prix;
    }

    public void setEvenement(Evenement evenement) {
        Evenement = evenement;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
