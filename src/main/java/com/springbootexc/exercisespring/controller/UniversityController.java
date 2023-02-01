package com.springbootexc.exercisespring.controller;

import com.springbootexc.exercisespring.model.dto.UniversityResponse;
import com.springbootexc.exercisespring.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @GetMapping(path = "/{country}")
    public UniversityResponse[] getUniversity(@PathVariable String country) {
        final UniversityResponse[] responses = universityService.getUniversity(country);
        return responses;
    }
}
