package com.example.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Publication {
    @Id
    private String title;
    private String year;
    private String link; // Updated field name to match Neo4j
    // private List<String> coAuthors;

    // @Relationship(type = "WROTE", direction = Relationship.Direction.INCOMING)
    private List<String> authors; // Ensure authors list is properly populated
    // @Relationship(type = "WROTE", direction = Relationship.Direction.OUTGOING)
    // private List<Author> authors;
    // @Relationship(type = "PUBLISHED_IN", direction =
    // Relationship.Direction.OUTGOING)
    @Relationship(type = "PUBLISHED_IN", direction = Relationship.Direction.OUTGOING)
    private Venue venue;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearAsInt() {
        return year != null ? (int) Double.parseDouble(year) : 0;
    }

    // public void setYear(int year) {
    // this.year = year;
    // }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // public List<String> getCoAuthors() {
    // return authors;
    // }

    // public void setCoAuthors(List<String> authors) {
    // this.authors = authors;
    // }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
