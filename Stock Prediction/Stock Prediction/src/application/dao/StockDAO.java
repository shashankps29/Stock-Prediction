package application.dao;

import application.model.StockData;
import application.utils.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {

    public List<StockData> getAllStockData() {
        List<StockData> list = new ArrayList<>();
        String sql = "SELECT * FROM stock_data";

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                StockData data = new StockData(
                        rs.getInt("id"),
                        rs.getString("stock_name"),
                        rs.getString("date"),
                        rs.getDouble("closing_price")
                );
                list.add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean addStock(StockData stock) {
        String sql = "INSERT INTO stock_data (stock_name, date, closing_price) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, stock.getStockName());
            pstmt.setString(2, stock.getDate());
            pstmt.setDouble(3, stock.getClosingPrice());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
