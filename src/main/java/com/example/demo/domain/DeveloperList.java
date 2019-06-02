package com.example.demo.domain;

//unser zusätliches Layer zwischen Logik und DB
public class DeveloperList {
    String name;
    long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
