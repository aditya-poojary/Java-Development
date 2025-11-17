package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        int k = (int) req.getAttribute("k");
        int sq = k * k;

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h2>Result</h2>");
        out.println("<p>Sum: " + k + "</p>");
        out.println("<p>Square of sum: " + sq + "</p>");
        out.println("<a href='index.jsp'>Go Back</a>");
        out.println("</body></html>");
    }
}
