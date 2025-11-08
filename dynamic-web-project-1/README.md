# Dynamic Web Project 1

A dynamic web application built with Java Servlets, JSP, and deployed on Apache Tomcat server.

## Project Structure

```
dynamic-web-project-1/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── HelloServlet.java
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           ├── css/
│           │   └── style.css
│           ├── js/
│           │   └── script.js
│           └── index.jsp
├── pom.xml
└── README.md
```

## Technologies Used

- **Java 21** (LTS)
- **Jakarta Servlet API 6.0**
- **JSP (JavaServer Pages)**
- **Apache Tomcat 10.x**
- **Maven** (Build Tool)
- **HTML5/CSS3/JavaScript**

## Prerequisites

- JDK 21 or higher
- Maven 3.6+
- Apache Tomcat 10.x (for standalone deployment)

## Building the Project

```bash
mvn clean package
```

This will create a WAR file in the `target` directory.

## Running the Application

### Option 1: Using Maven Tomcat Plugin (Embedded)

```bash
mvn tomcat7:run
```

Then open your browser and navigate to: `http://localhost:8080`

### Option 2: Deploy to Standalone Tomcat

1. Build the WAR file: `mvn clean package`
2. Copy `target/dynamic-web-project-1.war` to Tomcat's `webapps` directory
3. Start Tomcat server
4. Access: `http://localhost:8080/dynamic-web-project-1`

## Features

- **Home Page** - JSP page with server information
- **Hello Servlet** - Dynamic servlet that responds to GET/POST requests
- **Form Handling** - Interactive form with parameter passing
- **Modern UI** - Responsive design with CSS animations
- **Session Management** - Displays session information

## Endpoints

- `/` - Home page (index.jsp)
- `/hello` - Hello servlet
- `/hello?name=YourName` - Hello servlet with parameter

## Development

To modify the application:

1. Edit Java servlets in `src/main/java/com/example/`
2. Edit JSP pages in `src/main/webapp/`
3. Edit styles in `src/main/webapp/css/`
4. Edit JavaScript in `src/main/webapp/js/`
5. Rebuild with `mvn clean package`

## Notes

- This project uses Java 21 and Jakarta EE (not javax)
- Requires Tomcat 10.x or higher for Jakarta EE support
- For Tomcat 9.x or lower, use javax.servlet instead of jakarta.servlet
