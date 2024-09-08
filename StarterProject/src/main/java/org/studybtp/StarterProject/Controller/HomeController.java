package org.studybtp.StarterProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
}
