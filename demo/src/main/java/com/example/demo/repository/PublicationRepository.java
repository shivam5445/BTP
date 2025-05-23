package com.example.demo.repository;

import com.example.demo.dto.PublicationByYearDTO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Publication;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PublicationRepository extends Neo4jRepository<Publication, String> {

        @Query(value = """
                        MATCH (p:Publication)<-[:WROTE]-(a:Author)
                        WHERE toLower(p.title) STARTS WITH toLower($letter)
                        RETURN p, collect(a.name) AS authors
                        SKIP $skip LIMIT $limit
                        """)
        List<Publication> findPublicationsByStartingLetterWithPagination(String letter, long skip, long limit);

        @Query(value = """
                        MATCH (p:Publication)
                        WHERE toLower(p.title) STARTS WITH toLower($letter)
                        RETURN count(p)
                        """)
        long countPublicationsByStartingLetter(String letter);

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

        @Query("MATCH (a:Author {name: $name})-[:WROTE]->(p:Publication)-[:PUBLISHED_IN]->(v:Venue) " +
                        "RETURN p.year AS year, " +
                        "collect('[' + v.type + '] ' + p.title) AS publications " +
                        "ORDER BY p.year DESC")
        List<PublicationByYearDTO> findPublicationsGroupedByYear(@Param("name") String name);

        @Query("MATCH (p:Publication)-[:PUBLISHED_IN]->(v:Venue) WHERE v.name = $venueName RETURN p")
        List<Publication> findByVenueName(@Param("venueName") String venueName);

        @Query(value = """
                        MATCH (p:Publication)<-[:WROTE]-(a:Author)
                        WHERE toLower(p.title) CONTAINS toLower($name)
                        RETURN p, collect(a.name) AS authors
                        LIMIT 1000
                        """)
        List<Publication> searchPublications(String name);

}
