package com.cloudnativeplayground.microservicesmonitoringdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller to handle dashboard-related API requests.
 */
@RestController
public class DashboardController {

    /**
     * API to fetch the summary data for the dashboard.
     *
     * @return ResponseEntity with summary data and HTTP status.
     */
    @GetMapping("/api/dashboard/summary")
    public ResponseEntity<Map<String, Object>> getDashboardSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("serviceCount", 10); // Replace with dynamic data
        summary.put("activeAlerts", 3); // Replace with dynamic data
        summary.put("totalRequests", 1500); // Replace with dynamic data
        summary.put("uptime", "24 hours"); // Replace with dynamic data
        summary.put("welcomeMessage", "Welcome to the Microservices Monitoring Dashboard");

        return ResponseEntity.ok(summary);
    }
}
