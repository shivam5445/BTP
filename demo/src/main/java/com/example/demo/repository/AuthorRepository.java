package com.example.demo.repository;

import com.example.demo.entity.Author;
import com.example.demo.entity.Publication;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface AuthorRepository extends Neo4jRepository<Author, String> {
    @Query("MATCH (a:Author) WHERE toLower(a.name) STARTS WITH toLower($letter) RETURN a")
    List<Author> findAuthorsByStartingLetter(String letter);

    @Query("MATCH (a:Author {name: $name})-[:WROTE]->(p:Publication) RETURN p")
    List<String> findPublicationTitlesByAuthorName(@Param("name") String name);

}
