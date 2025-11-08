# Simple Web Project Build Script
# Compiles Java servlets and prepares the web application

Write-Host "Building Simple Dynamic Web Project..." -ForegroundColor Cyan

# Check if CATALINA_HOME or TOMCAT_HOME is set
$TOMCAT_HOME = $env:CATALINA_HOME
if (-not $TOMCAT_HOME) {
    $TOMCAT_HOME = $env:TOMCAT_HOME
}

if (-not $TOMCAT_HOME) {
    Write-Host "ERROR: Tomcat installation not found!" -ForegroundColor Red
    Write-Host "Please set CATALINA_HOME or TOMCAT_HOME environment variable" -ForegroundColor Yellow
    Write-Host "Example: `$env:CATALINA_HOME = 'C:\apache-tomcat-9.0.xx'" -ForegroundColor Yellow
    exit 1
}

Write-Host "Using Tomcat: $TOMCAT_HOME" -ForegroundColor Green

# Check if servlet-api.jar exists
$SERVLET_JAR = Join-Path $TOMCAT_HOME "lib\servlet-api.jar"
if (-not (Test-Path $SERVLET_JAR)) {
    Write-Host "ERROR: servlet-api.jar not found at: $SERVLET_JAR" -ForegroundColor Red
    exit 1
}

# Create classes directory if it doesn't exist
$CLASSES_DIR = "webapp\WEB-INF\classes"
if (-not (Test-Path $CLASSES_DIR)) {
    New-Item -ItemType Directory -Path $CLASSES_DIR -Force | Out-Null
}

# Compile Java files
Write-Host "`nCompiling Java servlets..." -ForegroundColor Cyan
$JAVA_FILES = Get-ChildItem -Path "src\com\example\*.java" -Recurse

javac -cp $SERVLET_JAR -d $CLASSES_DIR $JAVA_FILES

if ($LASTEXITCODE -eq 0) {
    Write-Host "✓ Compilation successful!" -ForegroundColor Green
    Write-Host "`nWeb application is ready in: webapp\" -ForegroundColor Green
    Write-Host "`nTo deploy:" -ForegroundColor Yellow
    Write-Host "  1. Copy webapp folder contents to Tomcat's webapps\simple-web-project" -ForegroundColor White
    Write-Host "  2. Start Tomcat" -ForegroundColor White
    Write-Host "  3. Open http://localhost:8080/simple-web-project/" -ForegroundColor White
} else {
    Write-Host "✗ Compilation failed!" -ForegroundColor Red
    exit 1
}
