<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Expressions Demo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>💬 JSP Expressions Demo</h1>
            <p class="subtitle">Output Java expressions directly to the page</p>
        </header>

        <main>
            <section class="demo-card">
                <h2>What are Expressions?</h2>
                <p>Expressions use &lt;%= %&gt; syntax to evaluate and output Java expressions.</p>
                
                <div class="code-example">
                    <h3>Example 1: Simple calculations</h3>
                    <p>5 + 3 = <%= 5 + 3 %></p>
                    <p>10 × 7 = <%= 10 * 7 %></p>
                    <p>100 / 4 = <%= 100 / 4 %></p>
                    <p>2³ = <%= Math.pow(2, 3) %></p>
                </div>

                <div class="code-example">
                    <h3>Example 2: String operations</h3>
                    <p>Uppercase: <%= "hello world".toUpperCase() %></p>
                    <p>Length: <%= "JavaServer Pages".length() %> characters</p>
                    <p>Substring: <%= "Programming".substring(0, 7) %></p>
                </div>

                <div class="code-example">
                    <h3>Example 3: Date and time</h3>
                    <p>Current timestamp: <%= System.currentTimeMillis() %></p>
                    <p>Current date: <%= new java.util.Date() %></p>
                    <p>Year: <%= java.time.Year.now() %></p>
                </div>

                <div class="code-example">
                    <h3>Example 4: Implicit objects</h3>
                    <p>Request method: <%= request.getMethod() %></p>
                    <p>Request URI: <%= request.getRequestURI() %></p>
                    <p>Server port: <%= request.getServerPort() %></p>
                    <p>Context path: <%= request.getContextPath() %></p>
                </div>
            </section>

            <div class="navigation">
                <a href="scriptlet-demo.jsp" class="btn">← Previous: Scriptlets</a>
                <a href="jstl-demo.jsp" class="btn">Next: JSTL →</a>
            </div>
        </main>
    </div>
</body>
</html>
