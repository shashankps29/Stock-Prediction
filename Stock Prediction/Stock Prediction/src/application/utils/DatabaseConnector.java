package application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String DB_URL = "jdbc:sqlite:stock_prediction.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    } 3`
}
