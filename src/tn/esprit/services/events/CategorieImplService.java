package tn.esprit.services.events;

import tn.esprit.models.Categorie;
import tn.esprit.services.ICrud;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieImplService implements ICrud<Categorie> {

    @Override
    public ArrayList<Categorie> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean add(Categorie categorie) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Categorie categorie) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Categorie categorie) {
        return false;
    }
}
