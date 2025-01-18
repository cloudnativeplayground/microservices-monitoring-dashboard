#!/bin/bash
# setup-alerts.sh - Configure alerts for Prometheus and Grafana

echo "Starting alert setup for Prometheus and Grafana..."

# Define Prometheus Alertmanager configuration
PROM_ALERT_CONFIG="global:
  resolve_timeout: 5m
route:
  group_by: ['alertname']
  group_wait: 30s
  group_interval: 5m
  repeat_interval: 12h
  receiver: 'default'
receivers:
  - name: 'default'
    email_configs:
      - to: 'alert@example.com'
        from: 'prometheus@example.com'
        smarthost: 'smtp.example.com:587'
        auth_username: 'your-username'
        auth_password: 'your-password'
"

# Create Prometheus Alertmanager configuration file
ALERTMANAGER_CONFIG_DIR="kubernetes"
ALERTMANAGER_FILE="$ALERTMANAGER_CONFIG_DIR/prometheus-alertmanager.yaml"

mkdir -p "$ALERTMANAGER_CONFIG_DIR"
echo "$PROM_ALERT_CONFIG" > "$ALERTMANAGER_FILE"

echo "Prometheus Alertmanager configuration created at $ALERTMANAGER_FILE"

# Setup Grafana alerts
GRAFANA_ALERTS="
{
  \"dashboard\": \"Microservices Dashboard\",
  \"panels\": [
    {
      \"name\": \"CPU Usage Alert\",
      \"condition\": \"avg() > 80\",
      \"message\": \"CPU usage is over 80%.\"
    },
    {
      \"name\": \"Memory Usage Alert\",
      \"condition\": \"avg() > 70\",
      \"message\": \"Memory usage is over 70%.\"
    }
  ]
}
"

GRAFANA_ALERTS_FILE="$ALERTMANAGER_CONFIG_DIR/grafana-alerts.json"

echo "$GRAFANA_ALERTS" > "$GRAFANA_ALERTS_FILE"

echo "Grafana alerts configuration created at $GRAFANA_ALERTS_FILE"

echo "Alert setup complete! Remember to deploy the configuration to your Kubernetes cluster."
