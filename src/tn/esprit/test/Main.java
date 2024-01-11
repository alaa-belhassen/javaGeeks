package tn.esprit.test;

import tn.esprit.models.Evenement;
import tn.esprit.services.events.EvenementImplService;
import tn.esprit.utils.DbConnection;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnection db = DbConnection.getInstance();
       // DbConnection.createTable(db.getCnx(),"role","idRole numeric primary Key,name varchar(20)");
        DbConnection.createTable(db.getCnx(),"evenement","idEvenement numeric primary Key," +
               "lieu varchar(20),max_places numeric,prix double precision,libelle varchar(40),date_event date,time_event time,duration numeric,status varchar(15)");
        Evenement evenement=new Evenement(1,"menzeh",12000,122,"cast",new Date(2000), new Timestamp(new Date(2000).getTime()),2,"valid");
        Evenement evenement1=new Evenement(12,"menzeh2",12000,122,"cast3",new Date(2000), new Timestamp(new Date(2000).getTime()),2,"valid");
        EvenementImplService evenementImplService=new EvenementImplService ();
      // evenementImplService.add(evenement);
       // evenementImplService.add(evenement1);
        System.out.print(EvenementImplService.getEvenements());
        System.out.println("********************************************************** \n");
        evenementImplService.delete(12);
        System.out.println("********************apres suppression****************************** \n");
        System.out.print(EvenementImplService.getEvenements());

    }
}
