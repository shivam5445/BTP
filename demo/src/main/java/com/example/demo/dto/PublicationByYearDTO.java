package com.example.demo.dto;

import java.util.List;

public class PublicationByYearDTO {
    private String year;
    private List<String> publications;

    // Constructor
    public PublicationByYearDTO(String year, List<String> publications) {
        this.year = year;
        this.publications = publications;
    }

    // Getters and Setters
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getPublications() {
        return publications;
    }

    public void setPublications(List<String> publications) {
        this.publications = publications;
    }
}