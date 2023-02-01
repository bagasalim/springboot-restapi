package com.springbootexc.exercisespring.repository;

import com.springbootexc.exercisespring.model.entity.User;

public interface UserRepositoryCustom {

    User create(User request);

    User findByIdCus(String Id);
}
