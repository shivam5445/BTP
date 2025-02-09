package com.example.demo.service;

import com.example.demo.repository.AuthorRepository;
import com.example.demo.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsByLetter(String letter) {
        return authorRepository.findAuthorsByStartingLetter(letter);
    }

    // Additional methods as needed
}
