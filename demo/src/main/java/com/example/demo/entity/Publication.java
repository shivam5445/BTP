package com.example.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Publication {
    @Id
    private String title;
    private int year;
    private String link; // Updated field name to match Neo4j

    @Relationship(type = "WROTE", direction = Relationship.Direction.INCOMING)
    private List<Author> authors; // Ensure authors list is properly populated

    @Relationship(type = "PUBLISHED_IN", direction = Relationship.Direction.OUTGOING)
    private Venue venue;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
