package com.cloudnativeplayground.microservicesmonitoringdashboard;

import com.cloudnativeplayground.microservicesmonitoringdashboard.controller.DashboardController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DashboardControllerTest {

    @InjectMocks
    private DashboardController dashboardController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDashboardSummary() {
        // Arrange & Act
        ResponseEntity<Map<String, Object>> response = dashboardController.getDashboardSummary();

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().get("welcomeMessage")).isEqualTo("Welcome to the Microservices Monitoring Dashboard");
    }
}
