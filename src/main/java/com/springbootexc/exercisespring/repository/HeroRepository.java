package com.springbootexc.exercisespring.repository;

import com.springbootexc.exercisespring.model.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
