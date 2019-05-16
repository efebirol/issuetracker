package com.example.demo.controller;

import com.example.demo.webservices.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;


    @Autowired
    public ArticleController(ArticleService articleService) {

        System.out.println("-- Articlecontroller.java - ArticleController() Konstruktor");
        this.articleService = articleService;
    }



}
