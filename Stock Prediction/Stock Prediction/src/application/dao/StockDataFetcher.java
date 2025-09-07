package application.dao;

import application.utils.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDataFetcher {

    public static List<String> getAllStockNames() {
        List<String> stockNames = new ArrayList<>();
        String query = "SELECT DISTINCT stock_name FROM stock_data";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                stockNames.add(rs.getString("stock_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stockNames;
    }

    public static List<Double> getHistoricalPrices(String stockName) {
        List<Double> prices = new ArrayList<>();
        String query = "SELECT closing_price FROM stock_data WHERE stock_name = ? ORDER BY date ASC";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, stockName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                prices.add(rs.getDouble("closing_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prices;
    }
}
