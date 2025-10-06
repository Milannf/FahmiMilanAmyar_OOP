package com.fahmi.backend.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/health")
    public Map<String, Object> healthCheck(){
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("message", "Jetpack Joyride Backend is running!");
        health.put("timestamp", System.currentTimeMillis());
        return health;

    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        Map<String, Object> info = new HashMap<>();
        info.put("application", "CS6_FahmiMilanAmyar_Backend");
        info.put("version", "1.0");
        info.put("description", "Backend for Jetpack Joyride Game API");

        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("players", "/api/players");
        endpoints.put("scores", "/api/scores");
        endpoints.put("leaderboard", "/api/leaderboard");
        endpoints.put("health", "/api/health");

        info.put("endpoints", endpoints);
        return info;
    }
}

