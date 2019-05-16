package com.example.demo.repository;

import com.example.demo.entity.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
    Developer findByName(String name);


}
