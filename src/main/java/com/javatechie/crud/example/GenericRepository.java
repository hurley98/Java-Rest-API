package com.javatechie.crud.example;

import java.util.List;

public interface GenericRepository<T> {
    int add(T object);

    T findById(int id);

    List<T> findAll();

    int deleteById(int id);

    int update(T object);
}
