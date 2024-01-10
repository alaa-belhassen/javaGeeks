package tn.esprit.test;

import tn.esprit.utils.DbConnection;

public class Main {
    public static void main(String[] args) {
        DbConnection db = DbConnection.getInstance();
        DbConnection.createTable(db.getCnx(),"sarra","idRole numeric primary Key,name varchar(20)");
    }
}