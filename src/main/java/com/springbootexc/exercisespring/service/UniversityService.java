package com.springbootexc.exercisespring.service;

import com.springbootexc.exercisespring.model.dto.UniversityResponse;

public interface UniversityService {
    UniversityResponse[] getUniversity(String country);
}
