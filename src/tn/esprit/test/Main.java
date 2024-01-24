package tn.esprit.test;

import tn.esprit.models.Categorie;
import tn.esprit.models.Evenement;
import tn.esprit.models.Reserver;
import tn.esprit.models.User;
import tn.esprit.services.events.CategorieImplService;
import tn.esprit.services.events.EvenementImplService;
import tn.esprit.services.events.ReservationImplService;
import tn.esprit.utils.DbConnection;
import tn.esprit.utils.Status;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        DbConnection db = DbConnection.getInstance();

        ArrayList<Categorie> categories=new ArrayList<>();

        CategorieImplService categorieImplService=new CategorieImplService();

        /*Categorie categorie1=new Categorie("foot","valid");
        Categorie categorie2=new Categorie("handball","valid");
        Categorie categorie3=new Categorie("volleyball","valid");

        System.out.println("*** partie add ***");
        categorieImplService.add(categorie1);
        categorieImplService.add(categorie2);
        categorieImplService.add(categorie3);
*/

        categories =categorieImplService.getAll();
        System.out.println(categories);
/*
        System.out.println("*** partie update ***");

        categories.get(2).setNom("aaaaa");
        categorieImplService.update(categories.get(2));
        System.out.println(categories);



        System.out.println("*** partie delete ***");

        categorieImplService.delete(categories.get(1));
        categories.remove(1);

        System.out.println(categories);




*/



        User user=new User();
        user.setIdUser(2);
        ArrayList<Evenement> evenements=new ArrayList<>();

        Evenement evenement=new Evenement("menzeh",12000,122,"cast1",LocalDate.now(), LocalTime.now(),2, Status.VALID.toString(),categories.get(0),"",user.getIdUser());
        Evenement evenement1=new Evenement("menzeh2",12000,122,"cast33",LocalDate.now(),LocalTime.now(),2,Status.VALID.toString(),categories.get(1),"",user.getIdUser());
        Evenement evenement2=new Evenement("lieu",1200,150,"22555",LocalDate.now(),LocalTime.now(),90,Status.VALID.toString(),categories.get(1),"",user.getIdUser());
        EvenementImplService evenementImplService=new EvenementImplService ();

        System.out.println("\n ********************Partie Add******************************* \n");

       evenementImplService.add(evenement);
       evenementImplService.add(evenement1);
        evenementImplService.add(evenement2);

        evenements=evenementImplService.getAll();
        System.out.println(evenements);

        System.out.println("\n ********************Partie update******************************* \n");

        //modif les champs
        //evenements.get(4).setPrix(3500);
        //update fl database
        //evenementImplService.update(evenements.get(4));

        System.out.println(evenements);

        System.out.println("\n ********************Partie delete******************************* \n");
       // evenementImplService.delete(evenements.get(1));

        System.out.println(evenements);









        System.out.println("*** partie add reservation ***");
      ArrayList<Reserver> reservers=new ArrayList<>();
      Reserver reserver1=new Reserver("codeQR1",35,LocalDate.now(),evenements.get(1),user,Status.VALID.toString());
      ReservationImplService reservationImplService=new ReservationImplService();
        reservationImplService.add(reserver1);

       reservers.add(reserver1);

       reservers=reservationImplService.getAll();
        System.out.println(reservers);

      System.out.println("*** partie update reservation ***");

      reserver1.setCodeQR("codeQr_Edited");
      reservers.get(0).setCodeQR("codeQr_Edited");
      reservationImplService.update(reservers.get(0));
      System.out.println(reservers);

      System.out.println("*** partie delete reservation ***");

      //reservers.remove(0);
      reservationImplService.delete(reservers.get(0));

      System.out.println(reservers);















}
}

