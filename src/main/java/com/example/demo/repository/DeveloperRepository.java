package com.example.demo.repository;

import com.example.demo.entity.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//SpringData - CrudRepository ist die Schnittstelle für den "findAll" (holt die DB Daten)
@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
    Developer findByName(String name);


    //alle Issues die noch nicht zugewiesen sind auf einen Developer
}
