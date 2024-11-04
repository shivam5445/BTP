package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Venue {
    @Id
    private String id;
    private String name;
    private String location;

    // Getters and Setters
}
