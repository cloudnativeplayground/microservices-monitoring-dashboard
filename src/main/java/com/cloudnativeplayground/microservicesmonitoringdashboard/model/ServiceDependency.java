package com.cloudnativeplayground.microservicesmonitoringdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.util.Objects;

/**
 * Represents a service dependency in the microservices ecosystem.
 */
@Entity
public class ServiceDependency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private String dependentServiceName;

    @Column(nullable = false)
    private String dependencyType; // e.g., HTTP, gRPC, Database

    @Column(nullable = false)
    private String status; // e.g., UP, DOWN

    public ServiceDependency() {
    }

    public ServiceDependency(String serviceName, String dependentServiceName, String dependencyType, String status) {
        this.serviceName = serviceName;
        this.dependentServiceName = dependentServiceName;
        this.dependencyType = dependencyType;
        this.status = status;
    }

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

    public String getDependentServiceName() {
        return dependentServiceName;
    }

    public void setDependentServiceName(String dependentServiceName) {
        this.dependentServiceName = dependentServiceName;
    }

    public String getDependencyType() {
        return dependencyType;
    }

    public void setDependencyType(String dependencyType) {
        this.dependencyType = dependencyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDependency that = (ServiceDependency) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(dependentServiceName, that.dependentServiceName) &&
                Objects.equals(dependencyType, that.dependencyType) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, dependentServiceName, dependencyType, status);
    }

    @Override
    public String toString() {
        return "ServiceDependency{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", dependentServiceName='" + dependentServiceName + '\'' +
                ", dependencyType='" + dependencyType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
