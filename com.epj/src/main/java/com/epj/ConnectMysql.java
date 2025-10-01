package com.epj;


import java.sql.*;

public class ConnectMysql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "Shivam31@"; // <-- use your MySQL password

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            System.out.println("✅ Connection established successfully! by Shivam Shukla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

