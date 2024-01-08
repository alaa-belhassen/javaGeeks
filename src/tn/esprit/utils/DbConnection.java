package tn.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private String user = "postgres";
    private String password = "postgres";
    private String url = "jdbc:postgresql://localhost:5433/javageeks";
    private static DbConnection instance;
    private Connection cnx;

    private DbConnection()  {
        try {
            cnx = DriverManager.getConnection(url,user,password);
            System.out.println("connected!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static DbConnection getInstance(){
        if(instance==null) instance= new DbConnection();
        return instance;
    };
}