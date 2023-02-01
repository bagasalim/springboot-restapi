package com.springbootexc.exercisespring.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "university")
public class UniversityResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("web_pages")
    private String[] website;
}
