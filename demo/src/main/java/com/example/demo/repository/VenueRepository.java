package com.example.demo.repository;

import com.example.demo.entity.Publication;
import com.example.demo.entity.Venue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenueRepository extends Neo4jRepository<Venue, String> {
    @Query("MATCH (v:Venue) RETURN DISTINCT v.type ORDER BY v.type")
    List<String> findDistinctVenueTypes();

    @Query("MATCH (v:Venue) WHERE v.type = 'Book Chapter' AND toUpper(v.name) STARTS WITH $letter RETURN DISTINCT v.name AS venueName ORDER BY v.name")
    List<String> findBookChapterVenuesByLetter(@Param("letter") String letter);

    @Query("MATCH (v:Venue) WHERE v.type = 'Conference' AND toUpper(v.name) STARTS WITH $letter RETURN DISTINCT v.name AS venueName ORDER BY v.name")
    List<String> findConferenceVenuesByLetter(@Param("letter") String letter);

}
