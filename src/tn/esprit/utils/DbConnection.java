package tn.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    private String user = "postgres";
    private String password = "admin";
    private String url = "jdbc:postgresql://localhost:5432/Ticketing";
    private static DbConnection instance;
    private static Connection cnx;

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void setInstance(DbConnection instance) {
        DbConnection.instance = instance;
    }

    public static Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }


    public static void createTable(Connection cnx , String table,String fields){
        Statement statement;
        try{
            String query= "create table "+table+"("+fields+");";
            statement=cnx.createStatement();
            statement.executeUpdate(query);
            System.out.println("table created ");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
