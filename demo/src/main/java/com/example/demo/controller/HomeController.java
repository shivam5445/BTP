package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @SpringBootApplication
// public class HomeController {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemoApplication.class, args);
// 	}

// }
@Controller
public class HomeController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("publications", authorService.getPublicationCount());
        model.addAttribute("authors", authorService.getAuthorCount());
        model.addAttribute("conferences", authorService.getConferenceCount());
        model.addAttribute("journals", authorService.getJournalCount());
        model.addAttribute("book", authorService.getBookCount());
        return "home";
    }
}
