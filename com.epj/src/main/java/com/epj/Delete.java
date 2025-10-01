package com.epj;

import java.sql.*;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/parul";
        String username = "root";
        String password = "Shivam31@";

        String query = "DELETE FROM ct WHERE id = ?";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Record deleted for ID: " + id+ " Thanks Shivam");
            } else {
                System.out.println("⚠️ No record found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
