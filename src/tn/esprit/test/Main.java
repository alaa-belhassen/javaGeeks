package tn.esprit.test;

import tn.esprit.models.Categorie;
import tn.esprit.models.Evenement;
import tn.esprit.models.Reserver;
import tn.esprit.models.User;
import tn.esprit.services.events.CategorieImplService;
import tn.esprit.services.events.EvenementImplService;
import tn.esprit.services.events.ReservationImplService;
import tn.esprit.utils.DbConnection;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

      ArrayList<Evenement> evenements=new ArrayList<>();

        DbConnection db = DbConnection.getInstance();
      DbConnection.createTable(db.getCnx(),"evenement","idEvenement numeric primary Key," +
               "lieu varchar(20),max_places numeric,prix double precision,libelle varchar(40),date_event date,time_event time,duration numeric,status varchar(15)");
        Evenement evenement=new Evenement(1,"menzeh",12000,122,"cast",LocalDate.now(), LocalTime.now(),2,"valid");
          /*  Evenement evenement1=new Evenement(12,"menzeh2",12000,122,"cast3",LocalDate.now(),LocalTime.now(),2,"valid");
        Evenement evenement2=new Evenement(15,"lieu",1200,150,"cast30",LocalDate.now(),LocalTime.now(),90,"valid");
        EvenementImplService evenementImplService=new EvenementImplService ();

        System.out.println("\n ********************Partie Add******************************* \n");

        evenementImplService.add(evenement);
        evenementImplService.add(evenement1);
        evenementImplService.add(evenement2);

        evenements.add(0,evenement);
        evenements.add(1,evenement1);
        evenements.add(2,evenement2);
        System.out.println(evenements);

        System.out.println("\n ********************Partie update******************************* \n");

        //modif les champs
        evenement.setPrix(3500);
        evenement.setDuration(100);
        //update fl database
        evenementImplService.update(evenement);
        //update fl arraylist
        evenements.get(0).setDuration(evenement.getDuration());
        evenements.get(0).setPrix(evenement.getPrix());

        System.out.println(evenements);

        System.out.println("\n ********************Partie delete******************************* \n");
        evenementImplService.delete(evenement);
        evenementImplService.delete(evenement2);
       // evenements.remove(evenement);
        evenements.remove(evenement2);
        System.out.println(evenements);



        ArrayList<Categorie> categories=new ArrayList<>();
        DbConnection.createTable(db.getCnx(),"categorie","idcategorie numeric primary Key," +
                "nom varchar(30),status varchar(15)");
        CategorieImplService categorieImplService=new CategorieImplService();

        Categorie categorie1=new Categorie(0,"foot","valid");
        Categorie categorie2=new Categorie(1,"handball","valid");
        Categorie categorie3=new Categorie(2,"volleyball","valid");

        System.out.println("*** partie add ***");
       categorieImplService.add(categorie1);
       categorieImplService.add(categorie2);
       categorieImplService.add(categorie3);

        categories.add(categorie1);
        categories.add(categorie2);
        categories.add(categorie3);

        //System.out.println(categories);

        System.out.println("*** partie update ***");
        categorie2.setNom("aaaa");
        categorieImplService.update(categorie2);
        categories.get(1).setNom("aaaa");

        System.out.println(categories);
        System.out.println("*** partie delete ***");

        categorieImplService.delete(categorie1);
        categories.remove(0);

        System.out.println(categories);


*/


          DbConnection.createTable(db.getCnx(),"utilisateur","idUser numeric primary Key" );


        DbConnection.createTable(db.getCnx(),"reserver","id_res numeric primary key , codeQr varchar(255) , prix_total double precision , " +
                "date_res date,idevenement numeric references evenement(idevenement) ,user_id numeric references utilisateur(iduser),status varchar(50) " );
        User util=new User(1);
        System.out.println("*** partie add reservation ***");
      ArrayList<Reserver> reservers = new ArrayList<>();
      Reserver reserver1=new Reserver(16,"codeQR1",35,LocalDate.now(),evenement,util,"valid");
      Reserver reserver2=new Reserver(255,"codeQR2",350,LocalDate.now(),evenement,util,"valid");
      ReservationImplService reservationImplService=new ReservationImplService();

      reservationImplService.add(reserver1);
       reservationImplService.add(reserver2);
        reservers.add(0,reserver1);
        reservers.add(1,reserver2);

        System.out.println(reservers);
      System.out.println("*** partie update reservation ***");

      reserver1.setCodeQR("codeQr_Edited");
      reservers.get(0).setCodeQR("codeQr_Edited");
      reservationImplService.update(reserver1);
      System.out.println(reservers);

      System.out.println("*** partie delete reservation ***");

      reservers.remove(0);
      reservationImplService.delete(reserver1);

      System.out.println(reservers);













      /**
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
      DbConnection.createTable(db.getCnx(),"categorie","idcategorie numeric primary Key," +
              "nom varchar(20),status varchar(20)");
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

      categorieImplService.update(categorie1);

      System.out.println( categorieImplService.getCategories());



      System.out.println("\n ******************** Reservation - user ******************************* \n");

     // DbConnection.createTable(db.getCnx(),"utilisateur","idUser numeric primary Key" );
      //System.out.println("\n ******************** user created ******************************* \n");

      DbConnection.createTable(db.getCnx(),"reserver","id_res numeric primary key , codeQr varchar(255) , prix_total double precision , date_res date,idevenement numeric references evenement(idevenement) ,user_id numeric references utilisateur(iduser),status varchar(50) " );

      System.out.println("\n ******************** table Reserver created ******************************* \n");
      ReservationImplService reservationImplService = new ReservationImplService();
      User utilisateur=new User(1);
      Reserver reserver = new Reserver(1,"sarra is bold",120,LocalDate.now(),evenement,utilisateur);
      //reservationImplService.add(reserver);
      System.out.println("\n ******************** update Reserver done ******************************* \n");

      reserver.setCodeQR("alaa is bold");
      reservationImplService.update(reserver);
      System.out.println("\n ******************** avant supp ******************************* \n");

      System.out.println(reservationImplService.getReservers());
      System.out.println("\n ******************** apres supp ******************************* \n");

      reservationImplService.delete(reserver);
      System.out.println(reservationImplService.getReservers());
*/

    }
}
