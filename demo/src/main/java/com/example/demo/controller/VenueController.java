package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.service.VenueService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping("/venue")
    public String venue(Model model) {
        List<String> venueTypes = venueService.getDistinctVenueTypes();
        model.addAttribute("types", venueTypes);
        return "venue";
    }
}
