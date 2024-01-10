package tn.esprit.services;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICrud <T> {
    ArrayList<T> getAll();
    boolean add(T t) throws SQLException;
    boolean delete(T t);
    boolean delete(int id) throws SQLException;
    boolean update(T t);

}
