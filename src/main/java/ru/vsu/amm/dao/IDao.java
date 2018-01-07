package ru.vsu.amm.dao;

import java.util.List;

public interface IDao<T> {

    void insert(T obj);
    void delete(int id);
    void update(T obj);
    T findById(int id);
    List<T> getAll();
}
