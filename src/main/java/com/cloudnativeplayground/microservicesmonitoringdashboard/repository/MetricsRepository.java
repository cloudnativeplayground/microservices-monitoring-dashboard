package com.cloudnativeplayground.microservicesmonitoringdashboard.repository;

import com.cloudnativeplayground.microservicesmonitoringdashboard.model.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for managing Metrics entities.
 */
@Repository
public interface MetricsRepository extends JpaRepository<Metrics, Long> {

    /**
     * Find metrics by service name.
     *
     * @param serviceName the name of the service
     * @return a list of metrics for the specified service
     */
    List<Metrics> findByServiceName(String serviceName);

    /**
     * Find metrics recorded after a specific timestamp.
     *
     * @param timestamp the timestamp to filter by
     * @return a list of metrics recorded after the given timestamp
     */
    //List<Metrics> findByTimestampAfter(Long timestamp);

    List<Metrics> findByTimestampAfter(LocalDateTime timestamp);
}
