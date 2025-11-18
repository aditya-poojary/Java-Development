param(
    [string]$TomcatHome
)

if (-not $TomcatHome) {
    Write-Host "Please provide the path to your Tomcat 9 installation via -TomcatHome" -ForegroundColor Yellow
    Write-Host "Example: .\deploy.ps1 -TomcatHome 'C:\\tools\\apache-tomcat-9.0.111'" -ForegroundColor Cyan
    exit 1
}

$warPath = Join-Path -Path (Get-Location) -ChildPath 'target\dynamic-web-project-1.war'
if (-not (Test-Path $warPath)) {
    Write-Host "WAR not found at $warPath. Build the project first: mvn clean package" -ForegroundColor Red
    exit 1
}

if (-not (Test-Path $TomcatHome)) {
    Write-Host "Tomcat home path does not exist: $TomcatHome" -ForegroundColor Red
    exit 1
}

$dest = Join-Path -Path $TomcatHome -ChildPath 'webapps\dynamic-web-project-1.war'
Copy-Item -Path $warPath -Destination $dest -Force
Write-Host "Copied WAR to $dest" -ForegroundColor Green

# Try to start Tomcat (startup.bat) if possible
$startup = Join-Path -Path $TomcatHome -ChildPath 'bin\startup.bat'
if (Test-Path $startup) {
    Write-Host "Starting Tomcat..." -ForegroundColor Cyan
    & $startup
    Write-Host "Tomcat started. Open http://localhost:8080/dynamic-web-project-1" -ForegroundColor Green
} else {
    Write-Host "Couldn't find 'startup.bat' in Tomcat home. Please start Tomcat manually and visit http://localhost:8080/dynamic-web-project-1" -ForegroundColor Yellow
}
