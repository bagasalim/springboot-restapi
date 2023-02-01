package com.springbootexc.exercisespring.controller;


import com.springbootexc.exercisespring.model.entity.User;
import com.springbootexc.exercisespring.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/create")
    @Operation(description = "API for creating User")
    private User create(@RequestBody User request) {
        return userService.create(request);
    }

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(description = "Rest API upload file")
    private ResponseEntity<String> uploadData(
            @RequestPart FilePart filePart) {
        String filename = filePart.filename();
        userService.uploadData(filePart);
        return ResponseEntity.ok("Upload File Success ("+filename+")" );
    }

    @GetMapping(path = "/find/{id}")
    @Operation(description = "API for finding User base on their ID")
    private User findById(@PathVariable String id){
        return userService.findById(id);
    }

    @GetMapping(path = "/find/all")
    @Operation(description = "API for finding all User")
    private List<User> findAll(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "5") int size){
        return userService.findAll(page, size);
    }

    @PutMapping(path = "/update/{id}")
    @Operation(description = "API for update User base on their ID")
    private User updateById(@PathVariable String id, @RequestBody User request){
        return userService.updateById( id, request);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(description = "API for delete User base on their ID")
    private Boolean delete(@PathVariable String id){
        return userService.delete(id);
    }
}
