@echo off
REM Batch script to generate folder structure and empty files for Microservices Monitoring Dashboard

REM Create directories
mkdir src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\config
mkdir src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\controller
mkdir src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\model
mkdir src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\repository
mkdir src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\service
mkdir src\main\resources\static
mkdir src\main\resources\templates
mkdir src\test\java\com\cloudnativeplayground\microservicesmonitoringdashboard
mkdir kubernetes
mkdir grafana\dashboards
mkdir grafana\datasources
mkdir scripts
mkdir .github\workflows

REM Create empty files
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\MicroservicesMonitoringDashboardApplication.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\config\PrometheusConfig.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\config\GrafanaConfig.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\config\ActuatorConfig.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\controller\DashboardController.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\controller\MetricsController.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\model\ServiceDependency.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\model\Alert.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\repository\MetricsRepository.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\service\MetricsService.java
type nul > src\main\java\com\cloudnativeplayground\microservicesmonitoringdashboard\service\AlertService.java
type nul > src\main\resources\application.properties
type nul > src\main\resources\grafana-dashboard.json
type nul > src\main\resources\prometheus.yml
type nul > src\main\resources\templates\dashboard.html
type nul > src\test\java\com\cloudnativeplayground\microservicesmonitoringdashboard\DashboardControllerTest.java
type nul > src\test\java\com\cloudnativeplayground\microservicesmonitoringdashboard\MetricsServiceTest.java
type nul > kubernetes\deployment.yaml
type nul > kubernetes\service.yaml
type nul > kubernetes\prometheus-configmap.yaml
type nul > kubernetes\grafana-configmap.yaml
type nul > kubernetes\namespace.yaml
type nul > grafana\dashboards\microservices-dashboard.json
type nul > grafana\datasources\prometheus-datasource.yaml
type nul > scripts\install-prometheus.sh
type nul > scripts\install-grafana.sh
type nul > scripts\setup-alerts.sh
type nul > .github\workflows\ci-cd.yml
type nul > .gitignore
type nul > build.gradle
type nul > Dockerfile

@echo Folder structure and files created successfully!
