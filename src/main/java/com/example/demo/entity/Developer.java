package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DEVELOPER")
public class Developer
{

  @Id
  @Column(name = "DEVELOPER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.IDENTITY, anstelle von AUTO damit JPA
  private long id;

  // Leerer Konstruktor für die JPA
  public Developer()
  {

  }

  public Developer(String name)
  {
    this.name = name;
  }

  @Column(name = "NAME")
  private String name;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }
}
