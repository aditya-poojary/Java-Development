<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dynamic Web Project 1</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <div class="container">
      <h1>Welcome to Dynamic Web Project 1</h1>
      <p class="subtitle">A Java Web Application running on Tomcat Server</p>

      <div class="info-box">
        <h2>Server Information</h2>
        <ul>
          <li><strong>Server:</strong> <%= application.getServerInfo() %></li>
          <li>
            <strong>Java Version:</strong> <%=
            System.getProperty("java.version") %>
          </li>
          <li><strong>Current Time:</strong> <%= new java.util.Date() %></li>
          <li><strong>Session ID:</strong> <%= session.getId() %></li>
        </ul>
      </div>

      <div class="form-box">
        <h2>Try the Servlet</h2>
        <form action="hello" method="get">
          <label for="name">Enter your name:</label>
          <input
            type="text"
            id="name"
            name="name"
            placeholder="Your name"
            required
          />
          <button type="submit">Submit</button>
        </form>
      </div>

      <div class="links">
        <a href="hello">Call HelloServlet</a> |
        <a href="hello?name=Java">Call with Parameter</a>
      </div>

      <div class="form-box">
        <h2>Addition Calculator</h2>
        <form action="add" method="get">
          Enter 1st number: <input type="text" name="num1" />
          <br />
          Enter 2nd number: <input type="text" name="num2" />
          <br />
          <input type="submit" value="Submit" />
        </form>
      </div>
    </div>

    <script src="js/script.js"></script>
  </body>
</html>
