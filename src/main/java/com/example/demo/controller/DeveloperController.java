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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

//@RestController
@Controller
@RequestMapping(value = "/getdeveloperscontroller")
public class DeveloperController {

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

        //Thymeleaf calls .html-Template with return-String value
        return "removedeveloper";
    }

    //1. Lösung - GET (REST)
    @RequestMapping(method = RequestMethod.GET)
    public String getDevelopers(Model model){
        logger.info("-- DeveloperController - GET a developer");

        //hole mir die List von Developers
        List<DeveloperList> developerLists = this.developerService.getAllDeveloperList();
        //mache die Liste für die View verfügbar
        model.addAttribute("modeldevelopers", developerLists);

        //.html muss so heissen wie der return-Wert
        return "getdeveloperspage";
    }

    //"@ResponseBody", um nicht über Thymeleaf gleich die View anzusteuern
    @RequestMapping(value = "/teststring", method = RequestMethod.GET)
    @ResponseBody
    public String getDevelopersTeststring(){
        logger.info("-- DeveloperController - output for string");

        return this.developerService.simpleDeveloperOutput();
    }

}
