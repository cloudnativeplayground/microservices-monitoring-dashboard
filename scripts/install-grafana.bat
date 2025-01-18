@echo off
echo Installing Grafana...

REM Check if PowerShell is available
where powershell >nul 2>nul
if %errorlevel% neq 0 (
    echo PowerShell is required to run this script.
    exit /b 1
)

REM Download Grafana installer for Windows
powershell -Command "& {Invoke-WebRequest -Uri https://dl.grafana.com/oss/release/grafana-10.1.2.windows-amd64.msi -OutFile grafana.msi}"

REM Install Grafana
msiexec /i grafana.msi /quiet /norestart

REM Check installation success
if %errorlevel% equ 0 (
    echo Grafana installed successfully!
    echo Access Grafana at: http://localhost:3000 (Default credentials: admin/admin)
) else (
    echo Grafana installation failed. Please check the logs.
)

REM Clean up
del grafana.msi

pause
