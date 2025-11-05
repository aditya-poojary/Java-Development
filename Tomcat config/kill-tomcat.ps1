# Kill Tomcat Process Script
# This script finds and kills any process using Tomcat ports 8080 and 8005

Write-Host "Checking for processes using Tomcat ports..." -ForegroundColor Yellow

# Check port 8080
$port8080 = netstat -ano | findstr ":8080" | Select-String "LISTENING"
if ($port8080) {
    $port8080 -match '\s+(\d+)\s*$' | Out-Null
    $pid = $matches[1]
    Write-Host "Found process $pid using port 8080" -ForegroundColor Cyan
    Stop-Process -Id $pid -Force -ErrorAction SilentlyContinue
    Write-Host "Killed process $pid" -ForegroundColor Green
}

# Check port 8005
$port8005 = netstat -ano | findstr ":8005" | Select-String "LISTENING"
if ($port8005) {
    $port8005 -match '\s+(\d+)\s*$' | Out-Null
    $pid = $matches[1]
    Write-Host "Found process $pid using port 8005" -ForegroundColor Cyan
    Stop-Process -Id $pid -Force -ErrorAction SilentlyContinue
    Write-Host "Killed process $pid" -ForegroundColor Green
}

# Verify ports are free
Start-Sleep -Seconds 1
$check8080 = netstat -ano | findstr ":8080" | Select-String "LISTENING"
$check8005 = netstat -ano | findstr ":8005" | Select-String "LISTENING"

if (-not $check8080 -and -not $check8005) {
    Write-Host "`n✅ Ports 8080 and 8005 are now free!" -ForegroundColor Green
    Write-Host "You can now start Tomcat." -ForegroundColor Green
} else {
    Write-Host "`n⚠️ Some ports are still in use. Try running the script again." -ForegroundColor Red
}
