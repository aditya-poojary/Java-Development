# Run Dynamic Web Project 1 on Tomcat

Write-Host "================================" -ForegroundColor Cyan
Write-Host "Dynamic Web Project 1" -ForegroundColor Green
Write-Host "================================" -ForegroundColor Cyan
Write-Host ""

Write-Host "Building the project..." -ForegroundColor Yellow
mvn clean package

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "Build successful!" -ForegroundColor Green
    Write-Host ""
    Write-Host "To run the application, choose one of the following options:" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "Option 1: Run with embedded Tomcat (Maven plugin)" -ForegroundColor Yellow
    Write-Host "  Command: mvn tomcat7:run" -ForegroundColor White
    Write-Host "  URL: http://localhost:8080/dynamic-web-project-1" -ForegroundColor White
    Write-Host ""
    Write-Host "Option 2: Deploy to standalone Tomcat" -ForegroundColor Yellow
    Write-Host "  1. Copy target\dynamic-web-project-1.war to Tomcat's webapps folder" -ForegroundColor White
    Write-Host "  2. Start Tomcat server" -ForegroundColor White
    Write-Host "  3. Access: http://localhost:8080/dynamic-web-project-1" -ForegroundColor White
    Write-Host ""
    Write-Host "WAR file location:" -ForegroundColor Cyan
    Write-Host "  target\dynamic-web-project-1.war" -ForegroundColor White
    Write-Host ""
} else {
    Write-Host "Build failed! Please check the error messages above." -ForegroundColor Red
}
