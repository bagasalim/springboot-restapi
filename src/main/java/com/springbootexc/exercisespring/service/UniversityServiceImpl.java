package com.springbootexc.exercisespring.service;

import com.springbootexc.exercisespring.model.dto.UniversityResponse;
import com.springbootexc.exercisespring.model.entity.University;
import com.springbootexc.exercisespring.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UniversityServiceImpl implements UniversityService{

    @Autowired
    UniversityRepository universityRepository;
    @Override
    public UniversityResponse[] getUniversity(String country) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UniversityResponse[]> response = restTemplate.getForEntity(
                "http://universities.hipolabs.com/search?country=" + country,
                UniversityResponse[].class);
        UniversityResponse[] body = response.getBody();
        if(body.length > 0) {
            for (UniversityResponse universityResponse : body){
                University university = new University(
                        null,
                        universityResponse.getName(),
                        universityResponse.getWebsite());

                universityRepository.save(university);
            }
        }
        return body;
    }
}
