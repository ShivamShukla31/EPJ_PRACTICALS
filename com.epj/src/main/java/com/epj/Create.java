package com.epj;

import java.sql.*;

public class Create {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/parul";
        String username = "root";
        String password = "Shivam31@";

        String createTable = "CREATE TABLE IF NOT EXISTS ct("
                           + "id INT PRIMARsY KEY,"
                           + "name VARCHAR(100) NOT NULL,"
                           + "salary INT NOT NULL)";
        
        String insertData = "INSERT INTO ct(id, name, salary) VALUES "
                          + "(100, 'Susruth', 95000),"
                          + "(101, 'Ajamad', 10000),"
                          + "(102, 'ShivamShukla', 70000),"
                          + "(103, 'Ujwalant', 25000)";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(createTable);
            System.out.println("✅ Table created.");

            int rowsInserted = stmt.executeUpdate(insertData);
            System.out.println("✅ " + rowsInserted + " row(s) inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
