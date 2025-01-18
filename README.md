# Microservices Monitoring Dashboard

Microservices Monitoring Dashboard is an open-source Java application designed to visualize service dependencies, logs, metrics, and alerts. It integrates seamlessly with Prometheus, Grafana, and Kubernetes to provide a comprehensive monitoring solution for microservices.

## Folder Structure and Purpose

```
microservices-monitoring-dashboard/
├── src/
│   ├── main/
│   │   ├── java/                      # Core application code
│   │   │   └── com/cloudnativeplayground/microservicesmonitoringdashboard/
│   │   │       ├── config/           # Configuration classes for Prometheus, Grafana, and Actuator
│   │   │       ├── controller/       # REST controllers for dashboard and metrics endpoints
│   │   │       ├── model/            # Data models for services and alerts
│   │   │       ├── repository/       # Repository interfaces for metrics data
│   │   │       └── service/          # Service layer for business logic
│   │   ├── resources/                # Application resources and configurations
│   │   │   ├── static/               # Static assets (if any)
│   │   │   ├── templates/            # HTML templates (e.g., dashboard UI)
│   │   │   ├── application.properties # Application configuration
│   │   │   ├── grafana-dashboard.json # Grafana dashboard definition
│   │   │   └── prometheus.yml         # Prometheus scrape configurations
│   ├── test/                         # Unit and integration tests
│       └── java/                     # Test code for the application
├── kubernetes/                       # Kubernetes deployment configurations
├── grafana/                          # Grafana dashboard and datasource configurations
├── scripts/                          # Helper scripts for setup and configuration
├── .github/                          # GitHub Actions workflows for CI/CD
├── .gitignore                        # Git ignore rules
├── build.gradle                      # Build configuration for Gradle
├── Dockerfile                        # Dockerfile to containerize the application
├── LICENSE                           # License information
└── README.md                         # Project documentation (this file)
```

## Application Flow

1. **Frontend**: Displays service dependencies, metrics, and alerts via Grafana.
2. **Backend**: Exposes REST APIs using Spring Boot for metrics and monitoring.
3. **Integration**: Prometheus scrapes metrics from Actuator endpoints, and Grafana visualizes the data.
4. **Kubernetes**: Manages deployments and service orchestration.

## Prerequisites

- Java 17 or later
- Gradle 7.5 or later
- Docker and Docker Compose
- Kubernetes (Minikube, kind, or any Kubernetes cluster)
- Prometheus and Grafana (can be installed using provided scripts)

## Installation and Configuration

1. **Clone the Repository**
   ```bash
   git clone https://github.com/cloudnativeplayground/microservices-monitoring-dashboard.git
   cd microservices-monitoring-dashboard
   ```

2. **Build the Application**
   ```bash
   ./gradlew build
   ```

3. **Setup Prometheus and Grafana**
   Use the provided scripts to install Prometheus and Grafana:
   ```bash
   scripts/install-prometheus.sh
   scripts/install-grafana.sh
   ```

4. **Deploy to Kubernetes**
   Apply the Kubernetes manifests:
   ```bash
   kubectl apply -f kubernetes/
   ```

5. **Run Locally (Optional)**
   To run without Kubernetes:
   ```bash
   docker build -t microservices-monitoring-dashboard .
   docker run -p 8080:8080 microservices-monitoring-dashboard
   ```

## Usage

### Start the Application
- **Locally**:
  ```bash
  ./gradlew bootRun
  ```
- **Kubernetes**:
  Ensure the pods are running:
  ```bash
  kubectl get pods
  ```

### Stop the Application
- **Locally**: Stop the running process in the terminal.
- **Kubernetes**:
  ```bash
  kubectl delete -f kubernetes/
  ```

### Test the Application
- Verify REST endpoints:
    - `http://localhost:8080/api/metrics`
    - `http://localhost:8080/api/alerts`

- Check Prometheus:
    - Navigate to `http://<prometheus-host>:9090`

- Check Grafana:
    - Navigate to `http://<grafana-host>:3000`

## License

This project is licensed under the GNU General Public License v3. See the [LICENSE](LICENSE) file for details.

## Maintainer

This project is maintained by **Aditya Pratap Bhuyan**, Senior Architect, Developer, Instructor, and Author.

- GitHub: [CloudNativePlayground](https://github.com/cloudnativeplayground)
- LinkedIn: [Aditya Pratap Bhuyan](https://linkedin.com/in/adityabhuyan)
