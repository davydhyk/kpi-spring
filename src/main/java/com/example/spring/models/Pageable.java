package com.example.spring.models;

public class Pageable {

    private int page = 0;
    private int size = 10;

    public Pageable(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getOffset() {
        return page * size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page < 0) this.page = 0;
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 1) this.size = 1;
        this.size = size;
    }
}
