import java.sql.Connection;
import application.utils.DatabaseConnector;

public class TestDB {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            if (conn != null) {
                System.out.println("✅ Database connected successfully!");
            } else {
                System.out.println("❌ Failed to connect.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
