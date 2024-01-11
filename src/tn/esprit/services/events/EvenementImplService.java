package tn.esprit.services.events;

import tn.esprit.models.Evenement;
import tn.esprit.services.ICrud;
import tn.esprit.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class EvenementImplService implements ICrud<Evenement> {

   private static ArrayList<Evenement> evenements;

    public EvenementImplService() throws SQLException {
        evenements = new ArrayList<>();
        this.getAll();
    }

    public static ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    @Override
    public ArrayList<Evenement> getAll() throws SQLException {

        String query1="select * from evenement where status='valid' ;";
        Statement statement=DbConnection.getCnx().createStatement();
        ResultSet resultSet= statement.executeQuery(query1);
      while (resultSet.next())
      {
          Evenement evenement=new Evenement();
          evenement.setIdEvenement(resultSet.getInt(1));
          evenement.setLieu(resultSet.getString(2));
          evenement.setMax_places(resultSet.getInt(3));
          evenement.setPrix(resultSet.getFloat(4));
          evenement.setLibelle(resultSet.getString(5));
          evenement.setDate_event(resultSet.getDate(6));
          evenement.setTime_event(resultSet.getTimestamp(7));
          evenement.setDuration(resultSet.getInt(8));
          evenement.setStatus(resultSet.getString(9));

          evenements.add(evenement);
      }

        /*
        for (int i = 0; i < evenements.size() ; i++) {
            System.out.println("Id Evennement : "+evenements.get(i).getIdEvenement());
            System.out.println("Lieu : "+evenements.get(i).getLieu());
            System.out.println("Nom evenement : "+evenements.get(i).getLibelle());
            System.out.println("Duration : "+evenements.get(i).getDuration());
            System.out.println("Max places : "+evenements.get(i).getMax_places());
            System.out.println("Date : "+evenements.get(i).getDate_event());
            System.out.println("Time : "+evenements.get(i).getTime_event());
            System.out.println("Prix : "+evenements.get(i).getPrix());
            System.out.println("Status : "+evenements.get(i).getStatus());

        }*/
        return evenements ;
    }

    @Override
    public boolean add(Evenement evenement) throws SQLException {
        // Check if the event already exists
        String selectQuery = "SELECT * FROM evenement WHERE libelle = ?";

        try (PreparedStatement selectStatement = DbConnection.getCnx().prepareStatement(selectQuery)) {
            selectStatement.setString(1, evenement.getLibelle());

            ResultSet resultSet = selectStatement.executeQuery();

            if (!resultSet.next()) {
                // Event does not exist, proceed with the insertion
                String insertQuery = "INSERT INTO Evenement(idevenement,libelle, duration, date_event, time_event, max_places, prix, lieu,status) " +
                        "VALUES (?,?, ?, ?, ?, ?, ?, ?,?)";

                try (PreparedStatement insertStatement = DbConnection.getCnx().prepareStatement(insertQuery)) {
                    insertStatement.setInt(1, evenement.getIdEvenement());
                    insertStatement.setString(2, evenement.getLibelle());
                    insertStatement.setInt(3, evenement.getDuration());
                    insertStatement.setDate(4, (Date) evenement.getDate_event());
                    insertStatement.setTimestamp(5, evenement.getTime_event()); // Assuming time_event is of type TIMESTAMP
                    insertStatement.setInt(6, evenement.getMax_places());
                    insertStatement.setDouble(7, evenement.getPrix());
                    insertStatement.setString(8, evenement.getLieu());
                    insertStatement.setString(9, evenement.getStatus());

                    insertStatement.executeUpdate();
                    System.out.println("successfully added");
                    // Assuming evenements is a List or some collection where you want to add the event
                    return evenements.add(evenement);
                }
            } else {
                System.out.println("Event already exists");
                return false;
            }
        }
    }


    @Override
    public boolean delete(Evenement evenement) throws SQLException {
        Statement statement=DbConnection.getCnx().createStatement();
        String query2="update evenement set status= 'Supprimé' where idEvenement ="+evenement.getIdEvenement()+";";
        statement.executeUpdate(query2);
        return  evenements.remove(evenement);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String selectQuery = "SELECT * FROM evenement WHERE idEvenement = ? and status='valid'";
        String updateQuery = "UPDATE evenement SET status = 'Supprimé' WHERE idEvenement = ?";

        try (Connection connection = DbConnection.getCnx();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            // Set parameter for the select statement
            selectStatement.setInt(1, id);

            // Execute the select statement
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Set parameter for the update statement
                    updateStatement.setInt(1, id);

                    // Execute the update statement
                    updateStatement.executeUpdate();

                    // Create an Evenement object and populate it with the data from the ResultSet
                    Evenement evenement = new Evenement();
                    evenement.setIdEvenement(resultSet.getInt("idEvenement"));
                    evenement.setLieu(resultSet.getString("lieu"));
                    evenement.setMax_places(resultSet.getInt("max_places"));
                    evenement.setPrix(resultSet.getFloat("prix"));
                    evenement.setLibelle(resultSet.getString("libelle"));
                    evenement.setDate_event(resultSet.getDate("date_event"));
                    evenement.setTime_event(resultSet.getTimestamp("time_event"));
                    evenement.setDuration(resultSet.getInt("duration"));
                    evenement.setStatus(resultSet.getString("status"));

                    // Remove the Evenement from the collection
                    return evenements.remove(evenement);

                } else {
                    System.out.println("Event not found");
                    return false;
                }
            }
        }
    }

    @Override
    public boolean update(Evenement evenement) throws SQLException {

        Statement statement=DbConnection.getCnx().createStatement();
        String query2="update evenement set lieu="+evenement.getLieu()+",libelle="+evenement.getLibelle()+",max_places="+evenement.getMax_places()+",prix="+evenement.getPrix()+",date_event="+evenement.getDate_event()+",time_event="+evenement.getTime_event()+",duration="+evenement.getDuration()+" where idEvenement ="+evenement.getIdEvenement()+";";
        statement.executeUpdate(query2);


        return false;
    }
}

