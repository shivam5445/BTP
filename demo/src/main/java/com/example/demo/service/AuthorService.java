package com.example.demo.service;

import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.dto.PublicationByYearDTO;
import com.example.demo.dto.PublicationDTO;
import com.example.demo.dto.YearlyPublicationsDTO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private Neo4jClient neo4jClient;

    public List<Author> getAuthorsByLetterWithPagination(String letter, int page, int size) {
        int skip = page * size;
        return authorRepository.findAuthorsByStartingLetterWithPagination(letter, skip, size);
    }

    public int countAuthorsByLetter(String letter) {
        return authorRepository.countAuthorsByStartingLetter(letter);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // public List<Author> getAuthorsByLetter(String letter) {
    // return authorRepository.findAuthorsByStartingLetter(letter);
    // }

    public List<String> getPublicationTitlesByAuthor(String name) {
        return authorRepository.findPublicationTitlesByAuthorName(name);
    }

    // public List<PublicationByYearDTO> getPublicationsGroupedByYear(String
    // authorName) {
    // return publicationRepository.findPublicationsGroupedByYear(authorName);
    // }
    // Additional methods as needed

    public List<Map<String, Object>> getPublicationsGroupedByYear(String name) {
        // Use neo4jClient to execute the query
        return (List<Map<String, Object>>) neo4jClient.query(
                "MATCH (author:Author {name: $name})-[:WROTE]->(p:Publication)-[:PUBLISHED_IN]->(v:Venue) " +
                        "OPTIONAL MATCH (a:Author)-[:WROTE]->(p) " +
                        "WHERE a <> author " +
                        "WITH p, v, author, p.year AS publicationYear, COLLECT(DISTINCT a.name) AS coauthors " +
                        "ORDER BY publicationYear DESC " +
                        "RETURN publicationYear AS year, " +
                        "COLLECT({title: p.title, link: p.link, venue: v.name, venueType: v.type, authors: coauthors + author.name}) AS publications "
                        +
                        "ORDER BY year DESC")
                .bind(name).to("name") // Bind 'name' to the query parameter
                .fetch() // Execute the query and fetch the results
                .all(); // Get all results
    }

    public Long getPublicationCount() {
        return authorRepository.findPublicationCount();
    }

    public Long getAuthorCount() {
        return authorRepository.findAuthorCount();
    }

    public Long getConferenceCount() {
        return authorRepository.findConferenceCount();
    }

    public Long getBookCount() {
        return authorRepository.findBookCount();
    }

    public Long getJournalCount() {
        return authorRepository.findJournalCount();
    }

    public List<Author> getAuthors(String name) {
        return authorRepository.searchAuthors(name);
    }
}
