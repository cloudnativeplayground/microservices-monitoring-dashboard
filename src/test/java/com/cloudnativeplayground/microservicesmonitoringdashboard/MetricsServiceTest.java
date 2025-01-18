package com.cloudnativeplayground.microservicesmonitoringdashboard.service;

import com.cloudnativeplayground.microservicesmonitoringdashboard.model.ServiceDependency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MetricsServiceTest {

    private MetricsService metricsService;

    @BeforeEach
    void setUp() {
        metricsService = new MetricsService();
    }

    @Test
    void testFetchMetrics() {
        Map<String, Object> metrics = metricsService.fetchMetrics();

        assertNotNull(metrics, "Metrics map should not be null");
        assertTrue(metrics.containsKey("uptime"), "Metrics should contain 'uptime'");
        assertTrue(metrics.containsKey("activeServices"), "Metrics should contain 'activeServices'");
        assertTrue(metrics.containsKey("errorRate"), "Metrics should contain 'errorRate'");
        assertTrue(metrics.containsKey("requestsPerSecond"), "Metrics should contain 'requestsPerSecond'");
    }

    @Test
    void testFetchMetricByName_ExistingMetric() {
        Object uptime = metricsService.fetchMetricByName("uptime");

        assertNotNull(uptime, "Uptime metric should not be null");
        assertTrue(uptime instanceof Integer, "Uptime should be an integer");
    }

    @Test
    void testFetchMetricByName_NonExistingMetric() {
        Object nonExistingMetric = metricsService.fetchMetricByName("nonExistingMetric");

        assertNull(nonExistingMetric, "Non-existing metric should return null");
    }

    @Test
    void testSendAlertsIfNecessary_NoAlert() {
        // Simulate no alert scenario
        metricsService.sendAlertsIfNecessary(); // No assertion needed, ensure no exceptions are thrown
    }

    @Test
    void testSendAlertsIfNecessary_AlertTriggered() {
        // Override fetchMetrics to simulate a high error rate
        Map<String, Object> highErrorRateMetrics = Map.of(
                "uptime", 12345,
                "activeServices", 12,
                "errorRate", 0.06,
                "requestsPerSecond", 250
        );

        MetricsService testService = new MetricsService() {
            @Override
            public Map<String, Object> fetchMetrics() {
                return highErrorRateMetrics;
            }
        };

        // Capture console output or implement alert logic to test
        testService.sendAlertsIfNecessary();
    }

    @Test
    void testFetchServiceDependencies() {
        List<ServiceDependency> dependencies = metricsService.fetchServiceDependencies();

        assertNotNull(dependencies, "Dependencies list should not be null");
        assertFalse(dependencies.isEmpty(), "Dependencies list should not be empty");
        assertEquals(2, dependencies.size(), "Should contain 2 dependencies");
    }
}
