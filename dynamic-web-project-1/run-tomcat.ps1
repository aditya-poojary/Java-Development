# Start Tomcat with Java 21 module options for JSP compilation
Write-Host "Starting Tomcat with Java 21 compatibility settings..." -ForegroundColor Cyan

# Set Maven options to open Java modules
$env:MAVEN_OPTS = '--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.io=ALL-UNNAMED --add-opens java.rmi/sun.rmi.transport=ALL-UNNAMED'

# Kill any existing process on port 8080
Write-Host "Checking for existing Tomcat on port 8080..." -ForegroundColor Yellow
$process = Get-NetTCPConnection -LocalPort 8080 -ErrorAction SilentlyContinue
if ($process) {
    Write-Host "Stopping existing process..." -ForegroundColor Yellow
    Stop-Process -Id $process.OwningProcess -Force -ErrorAction SilentlyContinue
    Start-Sleep -Seconds 2
}

# Start Tomcat
Write-Host "Starting embedded Tomcat..." -ForegroundColor Green
Write-Host "App will be available at: http://localhost:8080/dynamic-web-project-1/" -ForegroundColor Cyan
Write-Host ""
mvn tomcat7:run
