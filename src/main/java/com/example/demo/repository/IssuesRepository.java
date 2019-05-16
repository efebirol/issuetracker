package com.example.demo.repository;

import com.example.demo.entity.Issues;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuesRepository extends CrudRepository<Issues, Long> {
    Issues findByName(String name);


}
