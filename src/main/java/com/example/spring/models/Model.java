package com.example.spring.models;

public abstract class Model<T> {

    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
