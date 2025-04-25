package com.example.demo.service;

import com.example.demo.repository.PublicationRepository;
import com.example.demo.entity.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    public List<Publication> getPublicationsByLetterWithPagination(String letter, long skip, long limit) {
        return publicationRepository.findPublicationsByStartingLetterWithPagination(letter, skip, limit);
    }

    public long countPublicationsByLetter(String letter) {
        return publicationRepository.countPublicationsByStartingLetter(letter);
    }

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

    public List<Publication> getPublicationsByVenue(String venueName) {
        return publicationRepository.findByVenueName(venueName);
    }

}
