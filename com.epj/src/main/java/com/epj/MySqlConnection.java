package com.epj;

import java.sql.*;
import java.util.Scanner;

public class MySqlConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/parul";
        String username = "root";
        String password = "Shivam31@";  // <-- replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("✅ Database connected successfully!");

            // Insert using PreparedStatement
            String sql = "INSERT INTO students(name, age) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();

            pstmt.setString(1, name);
            pstmt.setInt(2, age);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Record inserted successfully!");
            }

            // Retrieve all records
            String selectQuery = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\n📌 Student Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String sname = rs.getString("name");
                int sage = rs.getInt("age");
                System.out.println("ID: " + id + " | Name: " + sname + " | Age: " + sage);
            }

            // Closing resources
            rs.close();
            stmt.close();
            pstmt.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

