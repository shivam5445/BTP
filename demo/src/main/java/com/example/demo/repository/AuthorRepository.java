package com.example.demo.repository;

import com.example.demo.entity.Author;
import com.example.demo.entity.Publication;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;
import java.util.Map;

public interface AuthorRepository extends Neo4jRepository<Author, String> {
        @Query("MATCH (a:Author) WHERE toLower(a.name) STARTS WITH toLower($letter) RETURN a SKIP $skip LIMIT $limit")
        List<Author> findAuthorsByStartingLetterWithPagination(@Param("letter") String letter, @Param("skip") int skip,
                        @Param("limit") int limit);

        @Query("MATCH (a:Author) WHERE toLower(a.name) STARTS WITH toLower($letter) RETURN count(a)")
        int countAuthorsByStartingLetter(@Param("letter") String letter);
        // @Query("MATCH (a:Author) WHERE toLower(a.name) STARTS WITH toLower($letter)
        // RETURN a")
        // List<Author> findAuthorsByStartingLetter(String letter);

        @Query("MATCH (a:Author {name: $name})-[:WROTE]->(p:Publication) RETURN p")
        List<String> findPublicationTitlesByAuthorName(@Param("name") String name);

        @Query("MATCH (author:Author {name: $name})-[:WROTE]->(p:Publication)-[:PUBLISHED_IN]->(v:Venue) " +
                        "WITH p, v, p.year AS publicationYear " +
                        "ORDER BY publicationYear DESC " +
                        "RETURN publicationYear AS year, " +
                        "COLLECT({title: p.title, venueType: v.type}) AS publications " +
                        "ORDER BY year DESC")
        List<Map<String, Object>> findPublicationsGroupedByYear(@Param("name") String name);

        @Query("MATCH (p:Publication) RETURN count(p)")
        Long findPublicationCount();

        @Query("MATCH (a:Author) RETURN count(a)")
        Long findAuthorCount();

        @Query("MATCH (v:Venue {type: 'Conference'}) RETURN count(v)")
        Long findConferenceCount();

        @Query("MATCH (v:Venue {type: 'Book Chapter'}) RETURN count(v)")
        Long findBookCount();

        @Query("MATCH (v:Venue {type: 'Journal'}) RETURN count(v)")
        Long findJournalCount();

        @Query("MATCH (a:Author) WHERE toLower(a.name) CONTAINS toLower($name) RETURN a.name AS name LIMIT 1000")
        List<Author> searchAuthors(String name);
}
