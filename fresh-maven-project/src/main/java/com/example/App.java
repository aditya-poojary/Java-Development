package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {
        
        String url = "jdbc:mysql://localhost:3306/java"; 
        String uname = "root";
        String password = "12345678";
        String query = "select * from student";
        String username = null;
        String insert = "insert into student values (?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, uname, password)) {
                 
                 // First: INSERT the new record
                 try (PreparedStatement st = con.prepareStatement(insert)) {
                     st.setInt(1, 8);  // Changed from 7 to 8
                     st.setString(2, "Bot");
                     st.setQueryTimeout(5);
                     int count = st.executeUpdate();
                     System.out.println("Inserted " + count + " row(s)");
                 }
                 
                 // Second: SELECT all records (including the new one)
                 try (Statement st2 = con.createStatement();
                      ResultSet rs = st2.executeQuery(query)) {
                     
                     while(rs.next()) {
                         username = rs.getString("name");
                         System.out.println(username);
                     }
                 }
            }
        } catch (Exception e) {
            System.out.println("Warning: could not query database: " + e.getMessage());
            username = "DemoUser";
        }
    }

    // helper used by unit tests
    public static String greet(String name) {
        if (name == null) return "Hello, World!";
        return "Hello, " + name + "!";
    }
}
