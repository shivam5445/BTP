package com.example.demo.repository;

import com.example.demo.entity.Venue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface VenueRepository extends Neo4jRepository<Venue, String> {
    @Query("MATCH (v:Venue) RETURN DISTINCT v.type ORDER BY v.type")
    List<String> findDistinctVenueTypes();
}
