<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Student Profile</title>
    <link rel="stylesheet" href="css/style.css" />
    <style>
      .profile-container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      }
      .profile-row {
        padding: 10px 0;
        border-bottom: 1px solid #eee;
      }
      .profile-label {
        font-weight: bold;
        color: #333;
        display: inline-block;
        width: 150px;
      }
      .profile-value {
        color: #666;
      }
      .status-message {
        padding: 10px;
        margin: 10px 0;
        border-radius: 4px;
      }
      .success {
        background-color: #d4edda;
        color: #155724;
      }
      .info {
        background-color: #d1ecf1;
        color: #0c5460;
      }
      .error {
        background-color: #f8d7da;
        color: #721c24;
      }
    </style>
  </head>
  <body>
    <div class="profile-container">
      <h2>Student Profile</h2>

      <%
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "tcet";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
          Class.forName("org.postgresql.Driver");
          con = DriverManager.getConnection(url, dbUsername, dbPassword);
          
          String createTableSql = "CREATE TABLE IF NOT EXISTS student (" +
                                  "rollno INTEGER PRIMARY KEY, " +
                                  "name VARCHAR(100), " +
                                  "marks VARCHAR(10))";
          pstmt = con.prepareStatement(createTableSql);
          pstmt.executeUpdate();
          pstmt.close();
          
          String checkSql = "SELECT * FROM student WHERE rollno = ?";
          pstmt = con.prepareStatement(checkSql);
          pstmt.setInt(1, 103);
          rs = pstmt.executeQuery();
          
          boolean dataExists = false;
          if (rs.next()) {
            dataExists = true;
          } else {
            rs.close();
            pstmt.close();
            
            String insertSql = "INSERT INTO student (rollno, name, marks) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(insertSql);
            pstmt.setInt(1, 103);
            pstmt.setString(2, "Aditya Poojary");
            pstmt.setString(3, "85");
            int rowsInserted = pstmt.executeUpdate();
            pstmt.close();
            
            if (rowsInserted > 0) {
      %>
              <div class="status-message success">Data inserted successfully!</div>
      <%
            }
            
            pstmt = con.prepareStatement(checkSql);
            pstmt.setInt(1, 103);
            rs = pstmt.executeQuery();
            if (rs.next()) {
              dataExists = true;
            }
          }
          
          if (dataExists) {
            if (rs.isBeforeFirst()) {
              rs.next();
            }
            int rollno = rs.getInt("rollno");
            String name = rs.getString("name");
            String marks = rs.getString("marks");
      %>
            <div class="status-message info">
              Student data retrieved successfully!
            </div>

            <div class="profile-row">
              <span class="profile-label">Roll Number:</span>
              <span class="profile-value"><%= rollno %></span>
            </div>

            <div class="profile-row">
              <span class="profile-label">Name:</span>
              <span class="profile-value"><%= name %></span>
            </div>

            <div class="profile-row">
              <span class="profile-label">Marks:</span>
              <span class="profile-value"><%= marks %></span>
            </div>
      <%
          } else {
      %>
            <div class="status-message error">No data found!</div>
      <%
          }
        } catch (ClassNotFoundException e) {
      %>
          <div class="status-message error">
            PostgreSQL Driver not found: <%= e.getMessage() %>
          </div>
      <%
          e.printStackTrace();
        } catch (SQLException e) {
      %>
          <div class="status-message error">
            Database error: <%= e.getMessage() %>
          </div>
      <%
          e.printStackTrace();
        } finally {
          try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      %>
    </div>
  </body>
</html>
