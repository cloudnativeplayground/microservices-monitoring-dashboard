@echo off
REM Batch script to install Prometheus on Windows

echo Starting Prometheus installation...

REM Define Prometheus version
set PROMETHEUS_VERSION=2.46.0
set PROMETHEUS_DIR=prometheus-%PROMETHEUS_VERSION%.windows-amd64

REM Download Prometheus
echo Downloading Prometheus v%PROMETHEUS_VERSION%...
curl -LO https://github.com/prometheus/prometheus/releases/download/v%PROMETHEUS_VERSION%/%PROMETHEUS_DIR%.zip

REM Extract Prometheus
echo Extracting Prometheus...
powershell -Command "Expand-Archive -Path '%PROMETHEUS_DIR%.zip' -DestinationPath ."

REM Move Prometheus to C:\Prometheus
if not exist "C:\Prometheus" mkdir "C:\Prometheus"
move %PROMETHEUS_DIR% "C:\Prometheus\"

REM Clean up downloaded zip file
del %PROMETHEUS_DIR%.zip

REM Create a Prometheus service
echo Setting up Prometheus as a Windows service...
sc create Prometheus binPath= "C:\Prometheus\%PROMETHEUS_DIR%\prometheus.exe --config.file=C:\Prometheus\%PROMETHEUS_DIR%\prometheus.yml --storage.tsdb.path=C:\Prometheus\%PROMETHEUS_DIR%\data" DisplayName= "Prometheus Monitoring" start= auto

REM Start Prometheus service
net start Prometheus

echo Prometheus installation completed successfully!
echo You can access Prometheus at http://localhost:9090
pause
