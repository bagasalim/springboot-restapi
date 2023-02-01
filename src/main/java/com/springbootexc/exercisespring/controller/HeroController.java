package com.springbootexc.exercisespring.controller;


import com.springbootexc.exercisespring.model.entity.Hero;
import com.springbootexc.exercisespring.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "Hero API")
@RequestMapping(path = "/hero")
public class HeroController {
    @Autowired
    HeroService heroService;

    public List<Hero> heroes = new ArrayList<>();

    public Integer counter = 1;

    @GetMapping(path = "/herolist")
    @ApiOperation(value = "Api")
    public List<Hero> listHero(){
        return heroService.listHero();
    }

    @PostMapping(path = "/add")
    @ApiOperation(value = "Api")
    public Hero addHero(@RequestBody Hero request){
        return heroService.addHero(request);
    }

    @PutMapping(path = "/update/{id}")
    @ApiOperation(value = "Api")
    public Boolean updateHero(@RequestBody Hero request, @PathVariable String id) {
        return heroService.updateHero(request, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ApiOperation(value = "Api")
    public Boolean deleteHero(@PathVariable String id) {
        return heroService.deleteHero(id);
    }

    @PatchMapping(path = "/status/{id}")
    @ApiOperation(value = "Api")
    public Boolean changeStatus(@PathVariable String id, @RequestParam Boolean status){
        return heroService.changeStatus(id, status);
    }

}
