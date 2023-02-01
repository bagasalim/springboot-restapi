package com.springbootexc.exercisespring.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Hellow Controller")

public class HelloController {
    @GetMapping(path = "/hellos")
    @ApiOperation(value = "Api")
    public static String Hello(@RequestParam("name") String name){
        return "Welcome to this page " + name;
    }
    @GetMapping(path = "/hellos/{name}")
    @ApiOperation(value = "Api")
    public static String Hellos(@PathVariable("name") String name){
        return "Welcome to this page " + name;
    }

}
