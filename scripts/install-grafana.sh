#!/bin/bash

# Check if the script is run as root
if [ "$EUID" -ne 0 ]; then
  echo "Please run as root or use sudo."
  exit 1
fi

echo "Installing Grafana..."

# Update package index
apt-get update -y

# Install dependencies
apt-get install -y software-properties-common wget apt-transport-https

# Add Grafana's APT repository
wget -q -O - https://packages.grafana.com/gpg.key | apt-key add -
add-apt-repository "deb https://packages.grafana.com/oss/deb stable main"

# Install Grafana
apt-get update -y
apt-get install -y grafana

# Enable and start Grafana service
systemctl enable grafana-server
systemctl start grafana-server

echo "Grafana installed successfully!"
echo "Access Grafana at: http://localhost:3000 (Default credentials: admin/admin)"
