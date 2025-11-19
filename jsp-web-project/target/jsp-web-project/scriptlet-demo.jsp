<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Scriptlets Demo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>📝 JSP Scriptlets Demo</h1>
            <p class="subtitle">Embedding Java code directly in JSP pages</p>
        </header>

        <main>
            <section class="demo-card">
                <h2>What are Scriptlets?</h2>
                <p>Scriptlets allow you to write Java code between &lt;% %&gt; tags.</p>
                
                <div class="code-example">
                    <h3>Example 1: Loop through numbers</h3>
                    <ul>
                        <% 
                            for(int i = 1; i <= 5; i++) {
                        %>
                            <li>Number: <%= i %> - Square: <%= i * i %></li>
                        <% 
                            }
                        %>
                    </ul>
                </div>

                <div class="code-example">
                    <h3>Example 2: Conditional statements</h3>
                    <% 
                        int hour = java.time.LocalTime.now().getHour();
                        String greeting;
                        
                        if(hour < 12) {
                            greeting = "Good Morning! 🌅";
                        } else if(hour < 17) {
                            greeting = "Good Afternoon! ☀️";
                        } else {
                            greeting = "Good Evening! 🌆";
                        }
                    %>
                    <p class="greeting"><%= greeting %></p>
                    <p>Current hour: <%= hour %></p>
                </div>

                <div class="code-example">
                    <h3>Example 3: Array iteration</h3>
                    <% 
                        String[] languages = {"Java", "Python", "JavaScript", "C++", "Go"};
                    %>
                    <ul>
                        <% for(String lang : languages) { %>
                            <li>💻 <%= lang %></li>
                        <% } %>
                    </ul>
                </div>
            </section>

            <div class="navigation">
                <a href="index.jsp" class="btn">← Back to Home</a>
                <a href="expression-demo.jsp" class="btn">Next: Expressions →</a>
            </div>
        </main>
    </div>
</body>
</html>
