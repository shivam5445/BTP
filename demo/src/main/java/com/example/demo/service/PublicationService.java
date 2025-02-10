package com.example.demo.service;

import com.example.demo.repository.PublicationRepository;
import com.example.demo.entity.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public List<Publication> getAllPublications() {
        return publicationRepository.findAllPublicationsWithAuthors();
    }

    public List<Publication> getPublicationsByLetter(String letter) {
        return publicationRepository.findPublicationsByStartingLetter(letter);
    }

    public Optional<Publication> getPublicationByTitle(String title) {
        return publicationRepository.findPublicationByTitle(title);
    }

}
