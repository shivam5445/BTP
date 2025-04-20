package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.VenueRepository;
import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public List<String> getDistinctVenueTypes() {
        return venueRepository.findDistinctVenueTypes();
    }
}
