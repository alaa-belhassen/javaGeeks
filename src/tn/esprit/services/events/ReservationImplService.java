package tn.esprit.services.events;

import tn.esprit.models.Categorie;
import tn.esprit.models.Evenement;
import tn.esprit.models.Reserver;
import tn.esprit.models.User;
import tn.esprit.services.ICrud;
import tn.esprit.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class ReservationImplService implements ICrud<Reserver> {


    private  ArrayList<Reserver> reservers;


    public ArrayList<Reserver> getReservers() {
        return reservers;
    }

    public void setReservers(ArrayList<Reserver> reservers) {
        this.reservers = reservers;
    }

    @Override
    public ArrayList getAll() throws SQLException {
        String query1="select * from reservation where status='valid' ;";
        Statement statement= DbConnection.getCnx().createStatement();
        ResultSet resultSet= statement.executeQuery(query1);
        while (resultSet.next())
        {
            Reserver reserver=new Reserver();
            reserver.setId_Res(resultSet.getInt(1));
            reserver.setCodeQR(resultSet.getString(2));
            reserver.setPrix_total(resultSet.getFloat(3));
            reserver.setEvenement((Evenement) resultSet.getObject(4));
            reserver.setUser((User) resultSet.getObject(5));

            reservers.add(reserver);
        }
        return reservers;
    }

    @Override
    public boolean add(Reserver reserver) throws SQLException {

        String selectQuery = "SELECT * FROM reserver WHERE codeQR = ?";
        try (PreparedStatement selectStatement = DbConnection.getCnx().prepareStatement(selectQuery)) {
            selectStatement.setString(1, reserver.getCodeQR());
            ResultSet resultSet = selectStatement.executeQuery();
            if (!resultSet.next()) {
                String insertQuery = "INSERT INTO reserver(id_Res,codeQR,prix_total,date_res,evenement,user_id,status) " +
                        "VALUES (?,?,?,?,?,?,?)";

                try (PreparedStatement insertStatement = DbConnection.getCnx().prepareStatement(insertQuery)) {
                    insertStatement.setInt(1, reserver.getId_Res());
                    insertStatement.setString(2, reserver.getCodeQR());
                    insertStatement.setFloat(3, reserver.getPrix_total());
                    insertStatement.setDate(4, Date.valueOf(reserver.getDate()));
                    insertStatement.setObject(5, reserver.getEvenement());
                    insertStatement.setObject(6, reserver.getUser());
                    insertStatement.setString(7, "valid");

                    insertStatement.executeUpdate();
                    System.out.println("successfully added");
                    return reservers.add(reserver);
                }
            } else {
                System.out.println("reservation already made");
                return false;
            }
        }




    }

    @Override
    public boolean delete(Reserver reserver) throws SQLException {
        Statement statement=DbConnection.getCnx().createStatement();
        String query2="update reserver set status= 'Supprimé' where idEvenement ="+reserver.getId_Res()+";";
        statement.executeUpdate(query2);

        for (int i = 0; i < reservers.size() ; i++) {
            if(reservers.get(i).getId_Res()==reserver.getId_Res()){
                reservers.remove(reservers.get(i));
            }
        }


        return  true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String selectQuery = "SELECT * FROM reserver WHERE id_res = ? and status='valid'";
        String updateQuery = "UPDATE reserver SET status = 'Supprimé' WHERE id_res = ?";
        try (Connection connection = DbConnection.getCnx();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            // parametre requete select
            selectStatement.setInt(1, id);
            try {

                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {

                    // parametre requete update
                    updateStatement.setInt(1, id);
                    updateStatement.executeUpdate();

                    //    evenements.get(evenements.indexOf(resultSet));

                    for (int i = 0; i < reservers.size() ; i++) {
                        if(reservers.get(i).getId_Res()==id){
                            reservers.remove(reservers.get(i));
                        }
                    }
                    return true;

                } else {
                    System.out.println("la categorie est déja supprimé");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
    @Override
    public boolean update(Reserver reserver) throws SQLException {
        try (PreparedStatement statement = DbConnection.getCnx().prepareStatement(
                "UPDATE evenement SET lieu=?, libelle=?, max_places=?, prix=?, date_event=?, time_event=?, duration=? WHERE idEvenement=?")) {

            statement.setFloat(1, reserver.getPrix_total());
            statement.setDate(2, Date.valueOf(reserver.getDate()));
            statement.setFloat(3, reserver.getPrix_total());
            statement.setString(4, reserver.getCodeQR());

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0) {

                for (int i = 0; i < reservers.size(); i++) {
                    if (reservers.get(i).getId_Res() == reserver.getId_Res()) {
                        reservers.get(i).setDate(reserver.getDate());
                        reservers.get(i).setPrix_total(reserver.getPrix_total());
                        reservers.get(i).setCodeQR(reserver.getCodeQR());

                    }
                }
                return true;
            }else {
                return false;
            }

        }
}
}
