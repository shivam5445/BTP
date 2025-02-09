package com.example.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Publication {
    @Id
    private String id;
    private String title;
    private int year;
    private String Link;

    @Relationship(type = "AUTHORED", direction = Relationship.Direction.INCOMING)
    private List<Author> authors;

    @Relationship(type = "PUBLISHED_IN", direction = Relationship.Direction.OUTGOING)
    private Venue venue;

    // Getters and Setters
}
