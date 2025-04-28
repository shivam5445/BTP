package com.example.demo.dto;

import java.util.*;

public class PublicationDTO {
    private String title;
    private String venueType;

    // Constructors
    public PublicationDTO() {
    }

    public PublicationDTO(String title, String venueType) {
        this.title = title;
        this.venueType = venueType;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }
}