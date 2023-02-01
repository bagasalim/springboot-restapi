package com.springbootexc.exercisespring.repository;

import com.springbootexc.exercisespring.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class UserRepositoryImpl implements UserRepositoryCustom{

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
     public User create(User request) {
        return mongoTemplate.insert(request, "user");
    }

    @Override
    public User findByIdCus(String Id) {
        User user = mongoTemplate.findById(Id, User.class);
        return user;
    }
}
