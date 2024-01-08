package tn.esprit.services;

import java.util.ArrayList;

public interface ICrud <T> {
    ArrayList<T> getAll();
    boolean add(T t);
    boolean delete(T t);
    boolean delete(int id);
    boolean update(T t);

}
