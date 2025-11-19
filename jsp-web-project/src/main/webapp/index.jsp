<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Web Project - Home</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>🚀 Welcome to JSP Web Project</h1>
            <p class="subtitle">Building Dynamic Web Applications with JavaServer Pages</p>
        </header>

        <main>
            <section class="info-card">
                <h2>📊 Server Information</h2>
                <div class="info-grid">
                    <div class="info-item">
                        <strong>Server:</strong>
                        <span><%= application.getServerInfo() %></span>
                    </div>
                    <div class="info-item">
                        <strong>Java Version:</strong>
                        <span><%= System.getProperty("java.version") %></span>
                    </div>
                    <div class="info-item">
                        <strong>Current Time:</strong>
                        <span><%= new java.util.Date() %></span>
                    </div>
                    <div class="info-item">
                        <strong>Session ID:</strong>
                        <span><%= session.getId() %></span>
                    </div>
                </div>
            </section>

            <section class="demo-card">
                <h2>🎯 JSP Features Demo</h2>
                <div class="feature-grid">
                    <a href="scriptlet-demo.jsp" class="feature-box">
                        <h3>📝 Scriptlets</h3>
                        <p>Java code embedded in JSP</p>
                    </a>
                    <a href="expression-demo.jsp" class="feature-box">
                        <h3>💬 Expressions</h3>
                        <p>Output Java expressions</p>
                    </a>
                    <a href="jstl-demo.jsp" class="feature-box">
                        <h3>🏷️ JSTL</h3>
                        <p>Tag libraries usage</p>
                    </a>
                    <a href="form-demo.jsp" class="feature-box">
                        <h3>📋 Forms</h3>
                        <p>Form handling in JSP</p>
                    </a>
                </div>
            </section>

            <%-- JSP Declaration example --%>
            <%! 
                private int visitCount = 0;
                
                public String getWelcomeMessage() {
                    return "Welcome to JSP Learning!";
                }
            %>

            <%-- JSP Scriptlet to increment visit count --%>
            <% visitCount++; %>

            <section class="stats-card">
                <h2>📈 Page Statistics</h2>
                <p class="visit-count">This page has been visited <strong><%= visitCount %></strong> time(s) in this session</p>
                <p class="message"><%= getWelcomeMessage() %></p>
            </section>
        </main>

        <footer>
            <p>&copy; 2025 JSP Web Project | Java 21 | Jakarta EE</p>
        </footer>
    </div>

    <script src="js/script.js"></script>
</body>
</html>
