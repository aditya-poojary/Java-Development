<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Form Handling Demo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>📋 JSP Form Handling Demo</h1>
            <p class="subtitle">Processing user input with JSP</p>
        </header>

        <main>
            <section class="demo-card">
                <h2>Submit Your Information</h2>
                
                <form action="form-demo.jsp" method="post" class="form-demo">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" required>
                    </div>

                    <div class="form-group">
                        <label for="age">Age:</label>
                        <input type="number" id="age" name="age" min="1" max="120" required>
                    </div>

                    <div class="form-group">
                        <label for="country">Country:</label>
                        <select id="country" name="country" required>
                            <option value="">Select a country</option>
                            <option value="India">India</option>
                            <option value="USA">USA</option>
                            <option value="UK">UK</option>
                            <option value="Canada">Canada</option>
                            <option value="Australia">Australia</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Programming Languages:</label>
                        <div class="checkbox-group">
                            <label><input type="checkbox" name="languages" value="Java"> Java</label>
                            <label><input type="checkbox" name="languages" value="Python"> Python</label>
                            <label><input type="checkbox" name="languages" value="JavaScript"> JavaScript</label>
                            <label><input type="checkbox" name="languages" value="C++"> C++</label>
                        </div>
                    </div>

                    <button type="submit" class="btn-primary">Submit</button>
                </form>
            </section>

            <%-- Process form data if submitted --%>
            <c:if test="${param.username != null}">
                <section class="result-card">
                    <h2>✅ Form Submitted Successfully!</h2>
                    <div class="result-info">
                        <p><strong>Username:</strong> ${param.username}</p>
                        <p><strong>Email:</strong> ${param.email}</p>
                        <p><strong>Age:</strong> ${param.age}</p>
                        <p><strong>Country:</strong> ${param.country}</p>
                        
                        <c:if test="${paramValues.languages != null}">
                            <p><strong>Selected Languages:</strong></p>
                            <ul>
                                <c:forEach var="lang" items="${paramValues.languages}">
                                    <li>${lang}</li>
                                </c:forEach>
                            </ul>
                        </c:if>

                        <%-- Additional info using scriptlet --%>
                        <% 
                            String username = request.getParameter("username");
                            if(username != null) {
                        %>
                            <p class="info-message">
                                Welcome, <%= username %>! Your registration is complete.
                            </p>
                        <% } %>
                    </div>
                </section>
            </c:if>

            <div class="navigation">
                <a href="jstl-demo.jsp" class="btn">← Previous: JSTL</a>
                <a href="index.jsp" class="btn">Back to Home</a>
            </div>
        </main>
    </div>

    <script src="js/script.js"></script>
</body>
</html>
