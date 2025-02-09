package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Venue {
    @Id
    private String name;
    private String type;

    // Getters and Setters
}
