package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String getAuthors(@RequestParam(value = "letter", required = false) String letter, Model model) {
        List<Author> authors;

        if (letter != null && !letter.isEmpty()) {
            authors = authorService.getAuthorsByLetter(letter);
            model.addAttribute("selectedLetter", letter); // To highlight selected letter
        } else {
            authors = authorService.getAllAuthors();
            model.addAttribute("selectedLetter", ""); // No letter selected
        }

        model.addAttribute("authors", authors);
        return "authorsView";
    }

    @GetMapping("/{name}")
    public String showAuthorPage(@PathVariable("name") String name, Model model) {
        model.addAttribute("authorName", name);
        return "authorDetails"; // Loads authorDetails.html from `src/main/resources/templates`
    }

}
