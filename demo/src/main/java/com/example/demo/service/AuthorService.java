package com.example.demo.service;

import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.dto.PublicationByYearDTO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsByLetter(String letter) {
        return authorRepository.findAuthorsByStartingLetter(letter);
    }

    public List<String> getPublicationTitlesByAuthor(String name) {
        return authorRepository.findPublicationTitlesByAuthorName(name);
    }

    public List<PublicationByYearDTO> getPublicationsGroupedByYear(String authorName) {
        return publicationRepository.findPublicationsGroupedByYear(authorName);
    }
    // Additional methods as needed
}
