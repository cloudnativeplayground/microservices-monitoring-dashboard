package com.cloudnativeplayground.microservicesmonitoringdashboard.service;

import com.cloudnativeplayground.microservicesmonitoringdashboard.model.Alert;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    // In-memory list to store alerts (for demonstration purposes)
    private final List<Alert> alerts = new ArrayList<>();

    /**
     * Create a new alert.
     *
     * @param alert the alert to create
     * @return the created alert
     */
    public Alert createAlert(Alert alert) {
        alerts.add(alert);
        return alert;
    }

    /**
     * Retrieve all alerts.
     *
     * @return a list of all alerts
     */
    public List<Alert> getAllAlerts() {
        return new ArrayList<>(alerts);
    }

    /**
     * Retrieve an alert by its ID.
     *
     * @param id the ID of the alert to retrieve
     * @return an Optional containing the alert if found, or empty if not found
     */
    public Optional<Alert> getAlertById(String id) {
        return alerts.stream()
                .filter(alert -> alert.getId().equals(id))
                .findFirst();
    }

    /**
     * Delete an alert by its ID.
     *
     * @param id the ID of the alert to delete
     * @return true if the alert was deleted, false otherwise
     */
    public boolean deleteAlert(String id) {
        return alerts.removeIf(alert -> alert.getId().equals(id));
    }
}
