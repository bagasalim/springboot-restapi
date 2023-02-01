package com.springbootexc.exercisespring.service;

import com.springbootexc.exercisespring.model.entity.Hero;
import com.springbootexc.exercisespring.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class HeroServiceImpl implements HeroService{
    @Autowired
    HeroRepository heroRepository;

    @Override
    public List<Hero> listHero() {
       return heroRepository.findAll();
    }

    @Override
    public Hero addHero(Hero request) {
        heroRepository.save(request);
        return request;
    }

    @Override
    public Boolean updateHero(Hero request, String id) {
        final Optional<Hero> result = heroRepository.findById(id);
        if (result.isPresent()){
            result.get().setName(request.getName());
            result.get().setSkin(request.getSkin());
            result.get().setDamage(request.getDamage());
            heroRepository.save(result.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteHero(String id) {
       heroRepository.deleteById(id);
       return true;
    }

    @Override
    public Boolean changeStatus(String id, Boolean isNewHero) {
        final Optional<Hero> result = heroRepository.findById(id);
        if (result.isPresent()){
            Hero hero = result.get();
            hero.setIsNewHero(isNewHero);
            heroRepository.save(result.get());
            return true;
        } else {
            return false;
        }
    }
}
