package com.cloudnativeplayground.microservicesmonitoringdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

/**
 * Entity representing Metrics data.
 */
@Entity
@Table(name = "metrics")
public class Metrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String metricName;
    @Column(name = "metric_value")
    private Double value;
    private LocalDateTime timestamp;

    // Default constructor
    public Metrics() {
    }

    // Constructor with fields
    public Metrics(String serviceName, String metricName, Double value, LocalDateTime timestamp) {
        this.serviceName = serviceName;
        this.metricName = metricName;
        this.value = value;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", metricName='" + metricName + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }
}
