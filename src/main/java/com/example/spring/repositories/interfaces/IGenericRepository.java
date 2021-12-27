package com.example.spring.repositories.interfaces;

import com.example.spring.models.Model;

import java.util.List;

public interface IGenericRepository<T extends Model<K>, K> {

    void create(T entity);

    T read(K key);

    boolean update(T entity);

    void delete(K key);

    List<T> readAll();

}