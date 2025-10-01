package com.epj;

import java.sql.*;

public class Read {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/parul";
        String username = "root";
        String password = "Shivam31@";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ct")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("ID: " + id + " | Name: " + name + " | Salary: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
