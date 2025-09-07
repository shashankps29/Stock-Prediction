package application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSQLiteConnection {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:stock_prediction.db";  // This file will be created automatically

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("✅ Connected to SQLite successfully!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection failed.");
            e.printStackTrace();
        }
    }
}
