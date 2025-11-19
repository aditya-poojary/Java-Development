package com.example.servlets;

import com.example.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get form parameters
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String country = request.getParameter("country");
        
        // Create User object
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        
        try {
            user.setAge(Integer.parseInt(ageStr));
        } catch (NumberFormatException e) {
            user.setAge(0);
        }
        
        user.setCountry(country);
        
        // Set user object as request attribute
        request.setAttribute("user", user);
        
        // Forward to result page
        request.getRequestDispatcher("/user-result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("form-demo.jsp");
    }
}
