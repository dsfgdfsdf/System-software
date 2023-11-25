package com.example.tourism_onthe_rail.service;

import com.example.tourism_onthe_rail.model.Route;
import com.example.tourism_onthe_rail.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
    public Route getRouteById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }
    public Route createRoute(Route route) {
        // Логіка для створення нового маршруту
        return routeRepository.save(route);
    }
    public ResponseEntity<?> updateRoute(Long id, Route updatedRoute) {
        Optional<Route> existingRouteOptional = routeRepository.findById(id);

        if (existingRouteOptional.isPresent()) {
            Route existingRoute = existingRouteOptional.get();
            existingRoute.setOrigin(updatedRoute.getOrigin());
            existingRoute.setDestination(updatedRoute.getDestination());
            existingRoute.setTrainDetails(updatedRoute.getTrainDetails());
            // Оновіть інші поля за потребою

            routeRepository.save(existingRoute);
            return ResponseEntity.ok(existingRoute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
