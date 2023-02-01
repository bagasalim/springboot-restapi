package com.springbootexc.exercisespring.repository;

import com.springbootexc.exercisespring.model.entity.University;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversityRepository extends MongoRepository<University, String> {
}
