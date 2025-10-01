package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.pojo.Student;

public class StudentsDao {
    private String url = "jdbc:mysql://localhost:3306/parul";
    private String username = "root";
    private String password = "Shivam31@"; // Change to your MySQL password
    private Connection conn;

    public StudentsDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert student
    public void create(int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, age);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Inserted student: " + id + ", " + name + ", " + age);
    }

    // Retrieve all students
    public List<Student> get() throws SQLException {
        List<Student> data = new ArrayList<>();
        String sql = "SELECT * FROM students";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            data.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
        }
        rs.close();
        pstmt.close();
        System.out.println("Fetched " + data.size() + " students.");
        return data;
    }
}



