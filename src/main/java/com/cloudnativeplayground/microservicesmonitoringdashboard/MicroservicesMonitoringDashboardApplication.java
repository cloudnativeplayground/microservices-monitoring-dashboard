package com.cloudnativeplayground.microservicesmonitoringdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main application class for the Microservices Monitoring Dashboard.
 * This application integrates Prometheus and Grafana for monitoring and visualizing service dependencies, logs, and metrics.
 */
@SpringBootApplication
@EnableScheduling
public class MicroservicesMonitoringDashboardApplication {

    /**
     * The entry point of the Microservices Monitoring Dashboard application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroservicesMonitoringDashboardApplication.class, args);
        System.out.println("Microservices Monitoring Dashboard is running...");
    }
}
