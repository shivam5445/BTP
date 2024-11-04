package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Publication {
    @Id
    private String id;
    private String title;
    private int year;

    @Relationship(type = "PUBLISHED_IN")
    private Venue venue;

    // Getters and Setters
}
