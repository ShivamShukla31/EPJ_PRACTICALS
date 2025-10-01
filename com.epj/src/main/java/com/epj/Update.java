package com.epj;


import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/parul";
        String username = "root";
        String password = "Shivam31@";

        String query = "UPDATE ct SET salary = ? WHERE id = ?";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter New Salary: ");
        int newSalary = sc.nextInt();

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, newSalary);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Salary updated for ID: " + id + " by Shivam Shukla");
            } else {
                System.out.println("⚠️ No record found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}

