package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Publication;
import com.example.demo.repository.VenueRepository;
import com.example.demo.repository.PublicationRepository;
import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    public List<String> getDistinctVenueTypes() {
        return venueRepository.findDistinctVenueTypes();
    }

    public List<String> getBookChapterVenuesByLetter(String letter) {
        return venueRepository.findBookChapterVenuesByLetter(letter);
    }

    public List<String> getConferenceVenuesByLetter(String letter) {
        return venueRepository.findConferenceVenuesByLetter(letter);
    }

    public List<String> getJournalVenuesByLetter(String letter) {
        return venueRepository.findJournalVenuesByLetter(letter);
    }

}
