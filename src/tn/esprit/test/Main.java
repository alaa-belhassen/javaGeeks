package tn.esprit.test;

import tn.esprit.models.Achat;
import tn.esprit.models.Produit;
import tn.esprit.services.Achat.ServiceAchat;
import tn.esprit.services.Achat.ServiceProduit;
import tn.esprit.utils.DbConnection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DbConnection db = DbConnection.getInstance();
        ServiceAchat SA = new ServiceAchat();
        ServiceProduit SP = new ServiceProduit();
        Produit p = new Produit ();
         p.setProductID(1);
         SP.add(p);

        //Achat a = new Achat ();
        //a.setIdAchat(4);
        //LocalDate dateAchat = LocalDate.now();
        //a.setDateAchat(dateAchat);
        //a.setIdClient(2);
        //SA.update(a);
        //SA.add(a);
        //SA.delete(4);
        ArrayList<Achat> LesAchats = new ArrayList<>();
        LesAchats = SA.getAll();
        for (Achat ac : LesAchats) {
            System.out.println(ac.toString());

        }

        ArrayList<Produit> Lesproduits  = new ArrayList<>();
        Lesproduits = SP.getAll();
        for (Produit pc : Lesproduits) {
            System.out.println(pc.toString());

        }

    }
}