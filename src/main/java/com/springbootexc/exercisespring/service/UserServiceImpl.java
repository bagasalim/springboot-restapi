package com.springbootexc.exercisespring.service;

import com.springbootexc.exercisespring.model.entity.User;
import com.springbootexc.exercisespring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User request) {
        return userRepository.save(request);
    }

    @Override
    public User findById(String Id) {
         User result = userRepository.findByIdCus(Id);

         if (result != null){
             return result;
         } else {
             return null;
         }
    }

    @Override
    public List<User> findAll(int page, int size) {
        PageRequest request = PageRequest.of(page, size, Sort.by("name").ascending());
        userRepository.findAll(request);
        return userRepository.findAll();
    }

    @Override
    public User updateById(String id, User request) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()){
            result.get().setName(request.getName());
            result.get().setGender(request.getGender());
            result.get().setNationality(request.getNationality());
            result.get().setAge(request.getAge());
            return userRepository.save(result.get());
        } else {
            throw new ExceptionInInitializerError("Data Not Found");
        }
    }

    @Override
    public boolean delete(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public void uploadData(FilePart filePart) {
        String CSV_SPLIT_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        filePart.content()
                .map(DataBuffer::asInputStream)
                .map(inputStream -> {
                    try {
                        return inputStream.readAllBytes();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(String::new)
                .flatMapIterable(data -> {
                    List<String> strings = Arrays.stream(data.split("\n")).collect(Collectors.toList());
                    String header = strings.remove(0);
                    return strings;
                })
                .map(data -> data.trim().split(CSV_SPLIT_REGEX))
                .doOnNext(columns -> {
                    String name = columns[0];
                    String gender = columns[1];
                    Integer age = Integer.valueOf(columns[2]);
                    String nationality = columns[3];
                    User user = new User(null, name, gender, age, nationality);
                    create(user);
                })
                .subscribe();
    }
}
