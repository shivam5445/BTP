package com.example.demo.repository;

import com.example.demo.entity.Publication;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PublicationRepository extends Neo4jRepository<Publication, String> {

        @Query("MATCH (a:Author)-[:WROTE]->(p:Publication) " +
                        "RETURN p, collect(a.name) as authors")
        List<Publication> findAllPublicationsWithAuthors();

        // @Query("MATCH (p:Publication) WHERE toLower(p.title) STARTS WITH
        // toLower($letter) RETURN p")
        // List<Publication> findPublicationsByStartingLetter(String letter);
        @Query("MATCH (p:Publication)<-[:WROTE]->(a:Author) " +
                        "WHERE toLower(p.title) STARTS WITH toLower($letter) " +
                        "RETURN p, COLLECT(a.name) AS authors")
        List<Publication> findPublicationsByStartingLetter(String letter);

        @Query("MATCH (p:Publication {title: $title})<-[:WROTE]-(a:Author) " +
                        "RETURN p, Collect(a.name) as authors")
        Optional<Publication> findPublicationByTitle(String title);

}
