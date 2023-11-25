package com.example.tourism_onthe_rail.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/Contact")
    public String Contact() {
        return "Contact";
    }

    @GetMapping("/About")
    public String About() {
        return "About";
    }

    @GetMapping("/Sign")
    public String Sign() {
        return "Sign";
    }
}
