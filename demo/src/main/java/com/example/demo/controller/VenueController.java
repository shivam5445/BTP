package com.example.demo.controller;

import com.example.demo.entity.Publication;
import com.example.demo.entity.Venue;
import com.example.demo.service.AuthorService;
import com.example.demo.service.VenueService;
import com.example.demo.service.PublicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VenueController {

    @Autowired
    private VenueService venueService;

    @Autowired
    private PublicationService publicationService;

    @GetMapping("/venue")
    public String venue(Model model) {
        return "venue";
    }

    @GetMapping("/venue/list")
    public String venue(@RequestParam(value = "letter", required = false) String letter, Model model) {
        // getBookChapterVenuesByLetter
        List<String> bookChapter = List.of();
        if (letter != null && !letter.isEmpty()) {
            bookChapter = venueService.getBookChapterVenuesByLetter(letter);
            model.addAttribute("selectedLetter", letter);
        }
        model.addAttribute("bookChapter", bookChapter);
        return "venuelist";
    }

    @GetMapping("/venue/list1")
    public String venue1(@RequestParam(value = "letter", required = false) String letter, Model model) {
        // getBookChapterVenuesByLetter
        List<String> Conference = List.of();
        if (letter != null && !letter.isEmpty()) {
            Conference = venueService.getConferenceVenuesByLetter(letter);
            model.addAttribute("selectedLetter", letter);
        }
        model.addAttribute("Conference", Conference);
        return "venuelist1";
    }

    @GetMapping("/venue/{name}")
    public String venuePublications(@PathVariable("name") String name, Model model) {
        List<Publication> publications = publicationService.getPublicationsByVenue(name);
        model.addAttribute("venueName", name);
        model.addAttribute("publications", publications);
        return "venue_publications";
    }

}
