package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping( "/sayHello")
    public String hello(){

        return "Hello";
    }

    @GetMapping( "/sayHello/{name}")
    public String helloxx(@PathVariable String name){

        return "Hello"+ name;
    }


}
