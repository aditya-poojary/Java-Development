# Simple Dynamic Web Project

A standalone Java web application without Maven - just pure servlet-based dynamic web project for Apache Tomcat.

## Project Structure

```
simple-web-project/
├── src/
│   └── com/
│       └── example/
│           ├── HelloServlet.java
│           └── TimeServlet.java
├── webapp/
│   ├── index.html
│   ├── index.jsp
│   ├── css/
│   │   └── style.css
│   ├── js/
│   │   └── script.js
│   └── WEB-INF/
│       ├── web.xml
│       ├── classes/
│       └── lib/
├── build.ps1
└── README.md
```

## Requirements

- Java JDK 8 or higher
- Apache Tomcat 9.x or 10.x
- servlet-api.jar (provided by Tomcat)

## How to Build

### Option 1: Using PowerShell Script

```powershell
.\build.ps1
```

### Option 2: Manual Compilation

```powershell
# Set your Tomcat installation path
$TOMCAT_HOME = "C:\apache-tomcat-9.0.xx"

# Compile Java classes
javac -cp "$TOMCAT_HOME\lib\servlet-api.jar" -d webapp\WEB-INF\classes src\com\example\*.java
```

## How to Deploy

1. **Copy to Tomcat webapps:**

   ```powershell
   Copy-Item -Recurse webapp "$env:CATALINA_HOME\webapps\myapp"
   ```

2. **Or create a WAR file:**

   ```powershell
   cd webapp
   jar -cvf ..\myapp.war *
   ```

   Then copy `myapp.war` to Tomcat's webapps folder.

3. **Start Tomcat and access:**
   - http://localhost:8080/myapp/

## Features

- 📄 Static HTML/CSS/JS files
- 🔄 JSP pages with server information
- 🎯 Servlet-based request handling
- 🎨 Modern responsive UI
- ⚡ No build tool dependencies (Maven/Gradle)

## Servlets

- **HelloServlet** (`/hello`) - Displays a greeting message
- **TimeServlet** (`/time`) - Returns current server time as JSON

## Development Notes

This is a pure dynamic web project without Maven or Gradle. It uses:

- Standard `javax.servlet` API (Servlet 4.0)
- Traditional web application structure
- Manual compilation and deployment

Perfect for learning servlet basics or deploying to shared hosting with Tomcat!
