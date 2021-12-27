package com.example.spring.services.interfaces;

import com.example.spring.models.Model;

import java.util.List;

public interface IGenericService<T extends Model<K>, K> {

    void create(T t);

    T get(K key);

    List<T> getAll();

    void update(T t);

    void delete(K key);
}