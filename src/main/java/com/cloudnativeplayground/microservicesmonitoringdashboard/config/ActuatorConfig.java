package com.cloudnativeplayground.microservicesmonitoringdashboard.config;

import org.springframework.boot.actuate.health.*;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.actuate.health.HealthContributorRegistry;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.HealthEndpointGroups;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Configuration
public class ActuatorConfig {

    /**
     * Configures security for Actuator endpoints.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }

    /**
     * Defines in-memory users with roles for basic authentication.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    /**
     * Exposes custom information on the `/actuator/info` endpoint.
     */
    @Bean
    public InfoContributor exampleInfoContributor() {
        return builder -> builder.withDetail("project", "Microservices Monitoring Dashboard")
                .withDetail("version", "1.0.0")
                .withDetail("maintainer", "Aditya Pratap Bhuyan");
    }



    // Example HealthIndicators
    @Bean
    public HealthIndicator databaseHealthIndicator() {
        return new HealthIndicator() {
            @Override
            public Health health() {
                // Simulate a database health check
                return Health.up().withDetail("database", "Database is running").build();
            }
        };
    }

    @Bean
    public HealthIndicator customServiceHealthIndicator() {
        return new HealthIndicator() {
            @Override
            public Health health() {
                // Simulate a custom service health check
                return Health.up().withDetail("customService", "Custom service is healthy").build();
            }
        };
    }



    /**
     * Exposes the info endpoint.
     */
    @Bean
    public InfoEndpoint infoEndpoint(InfoContributor... contributors) {
        return new InfoEndpoint(Arrays.stream(contributors).toList());
    }


}
