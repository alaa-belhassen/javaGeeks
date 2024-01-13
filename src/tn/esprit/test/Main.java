package tn.esprit.test;

import tn.esprit.models.Categorie;
import tn.esprit.models.Evenement;
import tn.esprit.services.events.CategorieImplService;
import tn.esprit.services.events.EvenementImplService;
import tn.esprit.utils.DbConnection;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnection db = DbConnection.getInstance();
        DbConnection.createTable(db.getCnx(),"evenement","idEvenement numeric primary Key," +
               "lieu varchar(20),max_places numeric,prix double precision,libelle varchar(40),date_event date,time_event time,duration numeric,status varchar(15)");
        Evenement evenement=new Evenement(1,"menzeh",12000,122,"cast",new Date(2000), new Timestamp(new Date(2000).getTime()),2,"valid");
        Evenement evenement1=new Evenement(12,"menzeh2",12000,122,"cast3",new Date(2000), new Timestamp(new Date(2000).getTime()),2,"valid");
        EvenementImplService evenementImplService=new EvenementImplService ();
/**/
        System.out.println("\n ********************Partie Add******************************* \n");
        // evenementImplService.add(evenement);
        // evenementImplService.add(evenement1);
        System.out.println("\n ********************Partie delete******************************* \n");

        System.out.println(" ******************** avant suppression ********************** \n");
        System.out.print(evenementImplService.getEvenements());
        System.out.println("********************************************************** \n");
        evenementImplService.delete(evenement);
        System.out.println("******************** apres suppression ****************************** \n");
        System.out.print(evenementImplService.getEvenements());
        System.out.println("********************************************************** \n");
        System.out.println("***********************Partie update*************************** \n");
        System.out.println("***********************avant update*************************** \n");
        System.out.print(evenementImplService.getEvenements());
        System.out.println("***********************apres update*************************** \n");
        evenement1.setLieu("hhhhhhhhhhhhh");
        evenementImplService.update(evenement1);
        System.out.print(evenementImplService.getEvenements());


        System.out.println("***********************partie Categorie*************************** \n");
        //DbConnection.createTable(db.getCnx(),"categorie","idcategorie numeric primary Key," +
          //      "nom varchar(20),status varchar(20)");
        System.out.println("\n *******************category created******************************* \n");
        System.out.println("\n ******************** Partie ADD ******************************* \n");

        CategorieImplService categorieImplService=new CategorieImplService ();

        System.out.println("\n ******************** avant ajout  ******************************* \n");
        System.out.println(categorieImplService.getCategories());

        Categorie categorie=new Categorie(1,"Foot","valid");
        Categorie categorie1=new Categorie(2,"Volley","valid");

        System.out.println("\n ******************** apres ajout ******************************* \n");
        categorieImplService.add(categorie);
        categorieImplService.add(categorie1);
        System.out.println( categorieImplService.getCategories());

        System.out.println("\n ******************** Partie delete ******************************* \n");

        System.out.println("\n ******************** avant delete  ******************************* \n");
        System.out.println(categorieImplService.getCategories());


        System.out.println("\n ******************** apres delete ******************************* \n");
        categorieImplService.delete(1);
        System.out.println(categorieImplService.getCategories());


        System.out.println("\n ******************** Partie update ******************************* \n");
        System.out.println("\n ******************** avant update  ******************************* \n");
        System.out.println(categorieImplService.getCategories());

        System.out.println("\n ******************** apres update ******************************* \n");
        categorie1.setNom("Foot1");

      //  categorieImplService.update(categorie1);

        System.out.println( categorieImplService.getCategories());






    }
}
