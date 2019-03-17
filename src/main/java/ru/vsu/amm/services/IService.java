package ru.vsu.amm.services;

import java.util.List;

public interface IService<T> {

    void save(T obj);
    void delete(T obj);
    T update(T obj);
    List<T> getAll();
}
