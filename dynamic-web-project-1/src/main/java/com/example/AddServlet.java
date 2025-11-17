package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{

    // public void service (HttpServletRequest req, HttpServletResponse res) throws IOException{
    //     int i = Integer.parseInt(req.getParameter("num1"));
    //     int j = Integer.parseInt(req.getParameter("num2"));

    //     int k = i + j;

    //     PrintWriter out = res.getWriter();
    //     out.println(k);

    //     //res.getWriter().println(k);  can be used instead of out

    // }

    // public void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    //     int i = Integer.parseInt(req.getParameter("num1"));
    //     int j = Integer.parseInt(req.getParameter("num2"));

    //     int k = i + j;

    //     // Set the sum as an attribute to pass to SqServlet
    //     req.setAttribute("k", k);

    //     // Forward to SqServlet to get the square
    //     RequestDispatcher rd = req.getRequestDispatcher("sq");
    //     rd.forward(req, res);
    // }

    // public void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
    //     int i = Integer.parseInt(req.getParameter("num1"));
    //     int j = Integer.parseInt(req.getParameter("num2"));

    //     int k = i / j;

    //     PrintWriter out = res.getWriter();
    //     out.println(k);

    //     //res.getWriter().println(k);
    // }

        public void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int k = i + j;

        // Redirect with the sum as a query parameter so SqServlet can compute its square
        res.sendRedirect("sq?k=" + k);
        // Forward to SqServlet to get the square
        // RequestDispatcher rd = req.getRequestDispatcher("sq");
        // rd.forward(req, res);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doGet(req, res);
    }
    
}
