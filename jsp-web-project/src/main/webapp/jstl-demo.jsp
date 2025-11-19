<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL Demo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>🏷️ JSTL (JSP Standard Tag Library) Demo</h1>
            <p class="subtitle">Using tag libraries for cleaner JSP code</p>
        </header>

        <main>
            <section class="demo-card">
                <h2>What is JSTL?</h2>
                <p>JSTL provides tags for common tasks like iteration, conditionals, and formatting.</p>
                
                <%-- Set variables --%>
                <c:set var="name" value="Java Developer" />
                <c:set var="age" value="25" />
                <c:set var="score" value="85" />

                <div class="code-example">
                    <h3>Example 1: Variables with &lt;c:set&gt; and &lt;c:out&gt;</h3>
                    <p>Name: <c:out value="${name}" /></p>
                    <p>Age: <c:out value="${age}" /></p>
                </div>

                <div class="code-example">
                    <h3>Example 2: Conditionals with &lt;c:if&gt;</h3>
                    <c:if test="${score >= 90}">
                        <p class="success">🌟 Excellent! Grade: A</p>
                    </c:if>
                    <c:if test="${score >= 70 && score < 90}">
                        <p class="info">👍 Good! Grade: B</p>
                    </c:if>
                    <c:if test="${score < 70}">
                        <p class="warning">📚 Keep learning! Grade: C</p>
                    </c:if>
                </div>

                <div class="code-example">
                    <h3>Example 3: Choose/When/Otherwise</h3>
                    <c:choose>
                        <c:when test="${age < 18}">
                            <p>You are a minor</p>
                        </c:when>
                        <c:when test="${age >= 18 && age < 60}">
                            <p>You are an adult</p>
                        </c:when>
                        <c:otherwise>
                            <p>You are a senior citizen</p>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="code-example">
                    <h3>Example 4: Iteration with &lt;c:forEach&gt;</h3>
                    <c:set var="fruits" value="Apple,Banana,Orange,Mango,Grapes" />
                    <ul>
                        <c:forEach var="fruit" items="${fruits.split(',')}" varStatus="status">
                            <li>${status.index + 1}. ${fruit}</li>
                        </c:forEach>
                    </ul>
                </div>

                <div class="code-example">
                    <h3>Example 5: Number range iteration</h3>
                    <p>Multiplication table of 5:</p>
                    <ul>
                        <c:forEach var="i" begin="1" end="10">
                            <li>5 × ${i} = ${5 * i}</li>
                        </c:forEach>
                    </ul>
                </div>
            </section>

            <div class="navigation">
                <a href="expression-demo.jsp" class="btn">← Previous: Expressions</a>
                <a href="form-demo.jsp" class="btn">Next: Forms →</a>
            </div>
        </main>
    </div>
</body>
</html>
