package com.example.demo.controller;


import com.example.demo.entity.Developer;
import com.example.demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeveloperController {
    @Autowired
    private DeveloperRepository repository;

    @RequestMapping(value="/developers", method= RequestMethod.GET)
    List<Developer> findAll(@RequestParam(required=false) String name){
       List<Developer> developers = new ArrayList<>();
        if(null==name){
            Iterable<Developer> results = this.repository.findAll();
            results.forEach(developer-> {developers.add(developer);});
        }else{
            Developer developer = this.repository.findByName(name);
            if(null!=developer) {
                developers.add(developer);
            }
        }
        return developers;
    }

    @GetMapping( "/add")
    public String addDeveloper(){
        return "add Developer";
    }

    @GetMapping( "/remove")
    public String removeDeveloper(){
        return "remove Developer";
    }


}