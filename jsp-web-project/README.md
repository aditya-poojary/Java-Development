# JSP Web Project

A comprehensive JavaServer Pages (JSP) web application demonstrating various JSP features and concepts.

## 📚 Project Structure

```
jsp-web-project/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           ├── models/
│       │           │   └── User.java
│       │           └── servlets/
│       │               └── UserServlet.java
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           ├── css/
│           │   └── style.css
│           ├── js/
│           │   └── script.js
│           ├── index.jsp
│           ├── scriptlet-demo.jsp
│           ├── expression-demo.jsp
│           ├── jstl-demo.jsp
│           └── form-demo.jsp
├── pom.xml
└── README.md
```

## 🚀 Features Demonstrated

### 1. **JSP Scriptlets** (`scriptlet-demo.jsp`)
- Embedding Java code in JSP
- Loops and iterations
- Conditional statements
- Array handling

### 2. **JSP Expressions** (`expression-demo.jsp`)
- Simple calculations
- String operations
- Date and time handling
- Implicit objects usage

### 3. **JSTL (JSP Standard Tag Library)** (`jstl-demo.jsp`)
- Core tags (`<c:set>`, `<c:out>`, `<c:if>`)
- Conditional tags (`<c:choose>`, `<c:when>`, `<c:otherwise>`)
- Iteration tags (`<c:forEach>`)
- Variable handling

### 4. **Form Handling** (`form-demo.jsp`)
- Form submission
- Parameter processing
- Data validation
- Result display

### 5. **Servlet Integration**
- Java servlets for backend logic
- MVC pattern implementation
- Request/Response handling

## 🛠️ Technologies Used

- **Java 21** (LTS)
- **Jakarta Servlet 6.0**
- **JSP (JavaServer Pages)**
- **JSTL 3.0** (JSP Standard Tag Library)
- **Maven** (Build Tool)
- **Apache Tomcat 10.x**
- **HTML5/CSS3/JavaScript**

## 📋 Prerequisites

- JDK 21 or higher
- Maven 3.6+
- Apache Tomcat 10.x (for standalone deployment)

## 🔧 Building the Project

```bash
mvn clean package
```

This will create a WAR file in the `target` directory.

## ▶️ Running the Application

### Option 1: Using Maven Tomcat Plugin (Embedded)

```bash
mvn tomcat7:run
```

Then open your browser and navigate to: `http://localhost:8080`

### Option 2: Deploy to Standalone Tomcat

1. Build the WAR file: `mvn clean package`
2. Copy `target/jsp-web-project.war` to Tomcat's `webapps` directory
3. Start Tomcat server
4. Access: `http://localhost:8080/jsp-web-project`

## 📖 Learning Paths

1. **Start with `index.jsp`** - Overview and navigation
2. **Explore `scriptlet-demo.jsp`** - Learn basic JSP syntax
3. **Check `expression-demo.jsp`** - Understand JSP expressions
4. **Study `jstl-demo.jsp`** - Master JSTL tags
5. **Practice with `form-demo.jsp`** - Form handling

## 🎯 Key Concepts Covered

- JSP Directives (`<%@ %>`)
- JSP Declarations (`<%! %>`)
- JSP Scriptlets (`<% %>`)
- JSP Expressions (`<%= %>`)
- Implicit Objects (request, response, session, application)
- JSTL Core Tags
- Form Processing
- MVC Pattern
- Servlet Integration

## 📝 Notes

- This project uses **Jakarta EE** (not javax)
- Requires **Tomcat 10.x or higher** for Jakarta EE support
- For Tomcat 9.x or lower, use javax.servlet instead of jakarta.servlet

## 🎨 Customization

- Modify styles in `webapp/css/style.css`
- Update JavaScript in `webapp/js/script.js`
- Add new JSP pages in `webapp/` directory
- Create servlets in `src/main/java/com/example/servlets/`

## 🤝 Best Practices

- Use JSTL instead of scriptlets when possible
- Separate business logic (servlets) from presentation (JSP)
- Follow MVC architecture
- Validate user input
- Handle exceptions properly
- Use meaningful variable names

## 📚 Additional Resources

- [Jakarta EE Documentation](https://jakarta.ee/)
- [JSP Tutorial](https://www.oracle.com/java/technologies/javaserver-pages.html)
- [JSTL Guide](https://jakarta.ee/specifications/tags/)
- [Apache Tomcat](https://tomcat.apache.org/)

---

**Happy Learning! 🎓**
