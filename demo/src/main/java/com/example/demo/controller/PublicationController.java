package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicationController {

    @GetMapping("/publication")
    public String publication(Model model) {
        return "publication"; // This is the template name
    }
}
