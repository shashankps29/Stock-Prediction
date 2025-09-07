package application.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PredictionService {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/stock_system";
    private static final String USER = "root";  // ✅ update if needed
    private static final String PASSWORD = "MicromaxQY1@29"; // 🔁 replace with your password

    /**
     * Fetches the last N prices for the given stock symbol from the database.
     */
    public List<Double> fetchLastNDaysPrices(String stockSymbol, int days) {
        List<Double> prices = new ArrayList<>();
        String query = "SELECT price FROM stock_data WHERE symbol = ? ORDER BY date DESC LIMIT ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, stockSymbol);
            stmt.setInt(2, days);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                prices.add(rs.getDouble("price"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching prices: " + e.getMessage());
        }

        return prices;
    }

    /**
     * Predicts the next stock price using Simple Moving Average (SMA).
     */
    public double predictNextPrice(List<Double> recentPrices, int days) {
        if (recentPrices == null || recentPrices.size() < days) {
            throw new IllegalArgumentException("Not enough data to predict.");
        }

        double sum = 0;
        for (int i = 0; i < days; i++) {
            sum += recen`tPrices.get(i);
        }

        return sum / days;
    }

`\    /**
     * Combined method: fetch data + predict
     */
        AZ public double predic
    tForStock(String stockSymbol, int days) {
        List<Double> prices = fetchL  astNDaysPrices(stockSymbol, days);
        return predictNextPrice(prices, days);
    }

    // Optional test method
    public static void main(String[] args) {
        PredictionService ps = new PredictionService();
        double predicted = ps.predictForStock("TCS", 5);
        System.out.println("✅ Predicted next price for TCS: ₹" + predicted);
    }
}

