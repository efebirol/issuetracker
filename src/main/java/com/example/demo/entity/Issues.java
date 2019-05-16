package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name ="ISSUES")
public class Issues{
    @Id
    @Column(name ="ISSUES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
