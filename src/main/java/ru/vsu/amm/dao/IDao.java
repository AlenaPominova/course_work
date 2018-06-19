package ru.vsu.amm.dao;

import java.util.List;

public interface IDao<T> {

    T insert(T obj);
    T findById(int id);
    T update(T obj);
    void delete(int id);
    List<T> getAll();
}
