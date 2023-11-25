package com.example.tourism_onthe_rail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {
    @GetMapping ("/showImage")
    public String showImage(Model model) {

        model.addAttribute("imageName", "logo.png");
        return "imagePage";
    }
}
