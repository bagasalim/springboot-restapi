package com.springbootexc.exercisespring.service;

import com.springbootexc.exercisespring.model.entity.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> listHero();
    Hero addHero(Hero request);
    Boolean updateHero(Hero request, String id);
    Boolean deleteHero(String id);

    Boolean changeStatus(String id, Boolean status);
}
