package application.utils;

import java.sql.Connection;
import java.sql.Statement;

public class SQLiteInitializer {

    public static void initializeDB() {
        String sql = """
            CREATE TABLE IF NOT EXISTS stock_data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                stock_name TEXT NOT NULL,
                date TEXT NOT NULL,
                closing_price REAL NOT NULL
            );
        """;

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table created or already exists.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
