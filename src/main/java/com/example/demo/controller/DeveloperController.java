package com.example.demo.controller;


import com.example.demo.domain.DeveloperList;
import com.example.demo.repository.DeveloperRepository;
import com.example.demo.webservices.DeveloperService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

//@RestController
@Controller
@RequestMapping(value = "/getdeveloperscontroller")
public class DeveloperController {
    @Autowired
    private DeveloperRepository repository;
    @Autowired
    private DeveloperService developerService;

    private Logger logger = getLogger(DeveloperController.class);


    @Autowired
    public DeveloperController(DeveloperService developerService) {
        System.out.println("-- DeveloperController.java - DeveloperController() Konstruktor");
        this.developerService = developerService;
    }

    //prüfen mit Rest API Tools (z. B. Postman, Intellij -> Endpoints -> Mappings etc.)
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public String addDeveloper() {
        logger.info("-- DeveloperController - Add a developer");

        return "adddeveloper";
    }

    @RequestMapping(value = "/remove", method= RequestMethod.DELETE)
    public String removeDeveloper() {
        logger.info("-- DeveloperController - Remove a developer");

        return "removedeveloper";
    }

    //1. Lösung - GET (REST)
    @RequestMapping(method = RequestMethod.GET)
    public String getDevelopers(Model model){

        //hole mir die List von Developers
        List<DeveloperList> developerLists = this.developerService.getAllDeveloperList();
        //mache die Liste für die View verfügbar
        model.addAttribute("modeldevelopers", developerLists);

        //.html muss so heissen wie der return-Wert
        return "getdeveloperspage";
    }

    //2. Lösung - GET (REST)
    //Mapping für die Developer (Teste mit Postman-Tool)
    /*@RequestMapping(value = "/developers/list", method = RequestMethod.GET)
    List<Developer> findAll(@RequestParam(required = false) String name) {
        return developerService.ListDevelopers(repository, name);
    }*/
}
