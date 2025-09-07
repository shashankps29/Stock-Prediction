package application.utils;

import java.sql.Connection;
import java.sql.Statement;

public class InsertSampleData {

    public static void insert() {
        String sql = """
            INSERT INTO stock_data (stock_name, date, closing_price) VALUES
            ('TATA', '2025-07-01', 850),
            ('TATA', '2025-07-02', 860),
            ('TATA', '2025-07-03', 870),
            ('TATA', '2025-07-04', 880),
            ('TATA', '2025-07-05', 890);
        """;

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("✅ Sample data inserted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
