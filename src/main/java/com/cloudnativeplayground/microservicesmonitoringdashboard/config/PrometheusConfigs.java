package com.cloudnativeplayground.microservicesmonitoringdashboard.config;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrometheusConfigs {

    /**
     * Creates a PrometheusMeterRegistry bean to expose application metrics to Prometheus.
     *
     * @return the PrometheusMeterRegistry instance
     */
    @Bean
    public PrometheusMeterRegistry prometheusMeterRegistry() {
        return new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
    }
}
