package com.cloudnativeplayground.microservicesmonitoringdashboard.controller;

import com.cloudnativeplayground.microservicesmonitoringdashboard.model.ServiceDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cloudnativeplayground.microservicesmonitoringdashboard.service.MetricsService;

import java.util.List;
import java.util.Map;

/**
 * Controller to expose endpoints for monitoring metrics and system status.
 */
@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    private final MetricsService metricsService;

    @Autowired
    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    /**
     * Get application metrics.
     *
     * @return a map of metrics and their values
     */
    @GetMapping
    public Map<String, Object> getMetrics() {
        return metricsService.fetchMetrics();
    }

    /**
     * Get service dependencies.
     *
     * @return a map of service dependencies and their status
     */
    @GetMapping("/dependencies")
    public List<ServiceDependency> getServiceDependencies() {
        return metricsService.fetchServiceDependencies();
    }
}
