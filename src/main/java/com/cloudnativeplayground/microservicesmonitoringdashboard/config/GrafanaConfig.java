package com.cloudnativeplayground.microservicesmonitoringdashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for Grafana integration.
 */
@Configuration
public class GrafanaConfig {

    /**
     * Bean for RestTemplate to interact with Grafana APIs.
     *
     * @return a RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Base URL for Grafana API.
     * Update this URL based on your Grafana deployment.
     *
     * @return the Grafana API base URL
     */
    public String grafanaApiBaseUrl() {
        return "http://localhost:3000/api";
    }

    /**
     * Grafana API Key for authentication.
     * Replace with your Grafana API Key.
     *
     * @return the Grafana API key
     */
    public String grafanaApiKey() {
        return "YOUR_GRAFANA_API_KEY";
    }
}
