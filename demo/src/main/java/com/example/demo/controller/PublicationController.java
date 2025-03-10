package com.example.demo.controller;

import com.example.demo.entity.Publication;
import com.example.demo.service.PublicationService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/publication")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    private final XmlMapper xmlMapper = new XmlMapper(); // XML Mapper for conversion

    @GetMapping
    public String getPublications(@RequestParam(value = "letter", required = false) String letter, Model model) {
        List<Publication> publications;

        if (letter != null && !letter.isEmpty()) {
            publications = publicationService.getPublicationsByLetter(letter);
            model.addAttribute("selectedLetter", letter);
        } else {
            publications = publicationService.getAllPublications();
            System.out.println("Publications with authors: " + publications);
            model.addAttribute("selectedLetter", "");
        }

        model.addAttribute("publications", publications);
        return "publication";
    }

    // New Endpoint to Return XML for a Specific Publication
    @GetMapping(value = "/xml", produces = "application/xml")
    @ResponseBody
    public String getPublicationAsXml(@RequestParam String title) throws Exception {
        Optional<Publication> publication = publicationService.getPublicationByTitle(title);
        if (publication.isPresent()) {
            return xmlMapper.writeValueAsString(publication.get());
        } else {
            return "<error>Publication not found</error>";
        }
    }
}
