package com.example.demo.dto;

import java.util.List;

public class YearlyPublicationsDTO {
    private String year;
    private List<PublicationDTO> publications;

    public YearlyPublicationsDTO() {
    }

    public YearlyPublicationsDTO(String year, List<PublicationDTO> publications) {
        this.year = year;
        this.publications = publications;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<PublicationDTO> getPublications() {
        return publications;
    }

    public void setPublications(List<PublicationDTO> publications) {
        this.publications = publications;
    }
}
