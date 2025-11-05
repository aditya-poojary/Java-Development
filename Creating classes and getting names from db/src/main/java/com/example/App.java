package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Student newStudent = new Student(8, "Virat");
            addStudent(newStudent);
            
            List<Student> students = getAllStudents();
            displayStudents(students);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addStudent(Student student) throws Exception {
        String query = "INSERT INTO student VALUES (?, ?)";
        
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement st = con.prepareStatement(query)) {
            
            st.setInt(1, student.getId());
            st.setString(2, student.getName());
            int count = st.executeUpdate();
            System.out.println("Added " + count + " student(s)");
        }
    }

    public static List<Student> getAllStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                students.add(new Student(id, name));
            }
        }
        return students;
    }

    public static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}