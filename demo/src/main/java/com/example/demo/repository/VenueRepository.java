package com.example.demo.repository;

import com.example.demo.entity.Venue;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface VenueRepository extends Neo4jRepository<Venue, String> {
}
