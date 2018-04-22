package ru.vsu.amm.dao;

public interface IDao<T> {

    T insert(T obj);
    T findById(int id);
}
