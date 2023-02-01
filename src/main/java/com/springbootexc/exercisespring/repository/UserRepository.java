package com.springbootexc.exercisespring.repository;

import com.springbootexc.exercisespring.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {

}
