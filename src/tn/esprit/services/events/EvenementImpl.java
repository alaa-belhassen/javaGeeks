package tn.esprit.services.events;

import tn.esprit.models.Evenement;
import tn.esprit.services.ICrud;
import tn.esprit.utils.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EvenementImpl implements ICrud<Evenement> {

   private ArrayList<Evenement> evenements;

    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    @Override
    public ArrayList<Evenement> getAll() {
        return null;
    }

    @Override
    public boolean add(Evenement evenement) throws SQLException {
        String query1="select from evenement where idEvenement ="+evenement.getLibelle()+";";
        Statement statement=DbConnection.getCnx().createStatement();
        ResultSet resultSet= statement.executeQuery(query1);
        if (resultSet.next()){
            String sql = "INSERT INTO Evenement VALUES (" +evenement.getLibelle()+
                    ","+evenement.getDuration()+
                    ","+evenement.getDate_event()+
                    ","+evenement.getTime_event()+
                    ","+evenement.getMax_places()+
                    ","+evenement.getDuration()+
                    ","+evenement.getPrix()+
                    ","+evenement.getLieu()+")";
            statement.executeUpdate(sql);

        }
        return  evenements.add(evenement);

    }

    @Override
    public boolean delete(Evenement evenement) {
    String query="delete from evenement where idEvenement ="+evenement.getIdEvenement();
    return evenements.remove(evenement);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query1="select from evenement where idEvenement ="+id+";";
        Statement statement=DbConnection.getCnx().createStatement();
        ResultSet resultSet= statement.executeQuery(query1);
        String query2="delete from evenement where idEvenement ="+id+";";
        statement.executeUpdate(query2);
        return  evenements.remove(resultSet);
    }

    @Override
    public boolean update(Evenement evenement) {
        return false;
    }
}

