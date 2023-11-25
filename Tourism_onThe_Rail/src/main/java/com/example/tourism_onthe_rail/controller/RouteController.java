package com.example.tourism_onthe_rail.controller;


import com.example.tourism_onthe_rail.model.Route;
import com.example.tourism_onthe_rail.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public String getAllRoutes(Model model) {
        List<Route> routes = routeService.getAllRoutes();
        model.addAttribute("routes", routes);
        return "route/list";
    }

    @GetMapping("/{id}")
    public String getRouteById(@PathVariable Long id, Model model) {
        Route route = routeService.getRouteById(id);
        model.addAttribute("route", route);
        return "route/details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("route", new Route());
        return "route/create";
    }

    @PostMapping("/create")
    public String createRoute(@ModelAttribute Route route) {
        routeService.createRoute(route);
        return "redirect:/routes";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Route route = routeService.getRouteById(id);
        model.addAttribute("route", route);
        return "route/update";
    }

    @PostMapping("/update/{id}")
    public String updateRoute(@PathVariable Long id, @ModelAttribute Route updatedRoute) {
        routeService.updateRoute(id, updatedRoute);
        return "redirect:/routes";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return "redirect:/routes";
    }
}
