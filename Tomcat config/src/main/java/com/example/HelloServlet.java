package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Database Connection App</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 50px; background-color: #f4f4f4; }");
        out.println("h1 { color: #2c3e50; }");
        out.println(".container { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
        out.println(".success { color: #27ae60; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1 class='success'>✅ Success!</h1>");
        out.println("<h2>Your WAR file is successfully deployed on Tomcat!</h2>");
        out.println("<p><strong>Application Name:</strong> Database Connection App</p>");
        out.println("<p><strong>Version:</strong> 1.0-SNAPSHOT</p>");
        out.println("<p><strong>Server:</strong> Apache Tomcat 9.0.111</p>");
        out.println("<p><strong>Java Version:</strong> " + System.getProperty("java.version") + "</p>");
        out.println("<hr>");
        out.println("<p>This servlet is running perfectly! 🚀</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
