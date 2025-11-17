package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        int k = Integer.parseInt(req.getParameter("k"));
        int sq = k * k;
        PrintWriter out = res.getWriter();
        out.println(sq);
        
    }

    // Add doGet so GET requests to /sq are handled (prevents HTTP 405)
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Delegate to doPost so both GET and POST behave the same
        doPost(req, res);
    }
}
