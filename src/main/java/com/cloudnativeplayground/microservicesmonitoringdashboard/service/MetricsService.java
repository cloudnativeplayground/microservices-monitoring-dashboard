package com.cloudnativeplayground.microservicesmonitoringdashboard.service;

import com.cloudnativeplayground.microservicesmonitoringdashboard.model.Metrics;
import com.cloudnativeplayground.microservicesmonitoringdashboard.model.ServiceDependency;
import com.cloudnativeplayground.microservicesmonitoringdashboard.repository.MetricsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for managing metrics data.
 */
@Service
public class MetricsService {

    private final MetricsRepository metricsRepository;

    public MetricsService(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    /*public List<Metrics> getRecentMetrics(Long startTime) {
        return metricsRepository.findByTimestampAfter(startTime);
    }*/

    public List<Metrics> getRecentMetrics(LocalDateTime startTime) {
        return metricsRepository.findByTimestampAfter(startTime);
    }
    /**
     * Fetches metrics from Prometheus or another data source.
     *
     * @return A map of metrics data.
     */
    public Map<String, Object> fetchMetrics() {
        // Simulate fetching metrics from Prometheus or another source
        Map<String, Object> metrics = new HashMap<>();

        metrics.put("uptime", 12345);
        metrics.put("activeServices", 12);
        metrics.put("errorRate", 0.02);
        metrics.put("requestsPerSecond", 250);

        return metrics;
    }

    /**
     * Fetches a specific metric by name.
     *
     * @param metricName The name of the metric to fetch.
     * @return The value of the metric or null if not found.
     */
    public Object fetchMetricByName(String metricName) {
        // Simulate fetching a specific metric
        Map<String, Object> metrics = fetchMetrics();
        return metrics.getOrDefault(metricName, null);
    }

    /**
     * Sends alert data or performs actions based on certain conditions.
     */
    public void sendAlertsIfNecessary() {
        Map<String, Object> metrics = fetchMetrics();

        // Example condition for sending an alert
        double errorRate = (double) metrics.get("errorRate");
        if (errorRate > 0.05) {
            System.out.println("ALERT: High error rate detected!");
            // Logic to send an alert (e.g., email, Slack, etc.)
        }
    }

    /**
     * Fetches service dependencies from a configuration file or database.
     * @return
     */
    // Mock implementation, replace with actual logic as needed
    public List<ServiceDependency> fetchServiceDependencies() {
        // Return a list of service dependencies (dummy data for now)
        return List.of(
                new ServiceDependency("ServiceA", "ServiceB", "dependencyType", "UP"),
                new ServiceDependency("ServiceB", "ServiceC", "dependencyType", "UP")
        );
    }
}