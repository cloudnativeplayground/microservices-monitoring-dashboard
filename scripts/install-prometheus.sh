#!/bin/bash

# Script to install and set up Prometheus on a Linux system

echo "Starting Prometheus installation..."

# Define Prometheus version
PROMETHEUS_VERSION="2.46.0"

# Create Prometheus user and directories
sudo useradd --no-create-home --shell /bin/false prometheus
sudo mkdir /etc/prometheus
sudo mkdir /var/lib/prometheus

# Download Prometheus
echo "Downloading Prometheus v${PROMETHEUS_VERSION}..."
wget https://github.com/prometheus/prometheus/releases/download/v${PROMETHEUS_VERSION}/prometheus-${PROMETHEUS_VERSION}.linux-amd64.tar.gz

# Extract and move Prometheus binaries
echo "Extracting Prometheus..."
tar -xvf prometheus-${PROMETHEUS_VERSION}.linux-amd64.tar.gz
cd prometheus-${PROMETHEUS_VERSION}.linux-amd64

sudo mv prometheus /usr/local/bin/
sudo mv promtool /usr/local/bin/

# Move configuration files and set ownership
sudo mv prometheus.yml /etc/prometheus/
sudo mv consoles /etc/prometheus/
sudo mv console_libraries /etc/prometheus/

sudo chown -R prometheus:prometheus /etc/prometheus
sudo chown -R prometheus:prometheus /var/lib/prometheus
sudo chown prometheus:prometheus /usr/local/bin/prometheus
sudo chown prometheus:prometheus /usr/local/bin/promtool

# Clean up
cd ..
rm -rf prometheus-${PROMETHEUS_VERSION}.linux-amd64 prometheus-${PROMETHEUS_VERSION}.linux-amd64.tar.gz

# Create a systemd service file
echo "Setting up Prometheus as a systemd service..."
sudo bash -c 'cat << EOF > /etc/systemd/system/prometheus.service
[Unit]
Description=Prometheus Monitoring System
Wants=network-online.target
After=network-online.target

[Service]
User=prometheus
Group=prometheus
Type=simple
ExecStart=/usr/local/bin/prometheus \\
    --config.file=/etc/prometheus/prometheus.yml \\
    --storage.tsdb.path=/var/lib/prometheus \\
    --web.console.templates=/etc/prometheus/consoles \\
    --web.console.libraries=/etc/prometheus/console_libraries

[Install]
WantedBy=multi-user.target
EOF'

# Reload systemd, enable and start Prometheus
sudo systemctl daemon-reload
sudo systemctl enable prometheus
sudo systemctl start prometheus

echo "Prometheus installation completed successfully!"
echo "You can access Prometheus at http://<your-server-ip>:9090"
