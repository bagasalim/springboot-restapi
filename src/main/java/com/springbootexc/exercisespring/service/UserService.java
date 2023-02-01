package com.springbootexc.exercisespring.service;

import com.springbootexc.exercisespring.model.entity.User;
import org.springframework.http.codec.multipart.FilePart;

import java.util.List;

public interface UserService {

    User create(User request);
    User findById(String id);

    List<User> findAll(int page, int size);

    User updateById(String id, User request);

    boolean delete(String id);

    void uploadData(FilePart filePart);
}
