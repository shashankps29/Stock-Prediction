package application.controller;

import application.dao.StockDAO;
import application.model.StockData;
import application.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStockController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField priceField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button addButton;

    @FXML
    private void handleAddStock() {
        String name = nameField.getText().trim();
        String date = dateField.getText().trim();
        String priceText = priceField.getText().trim();

        if (name.isEmpty() || date.isEmpty() || priceText.isEmpty()) {
            statusLabel.setText("❌ Please fill in all fields.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            StockData stock = new StockData(name, date, price);
            StockDAO dao = new StockDAO();
            boolean success = dao.addStock(stock);

            if (success) {
                statusLabel.setText("✅ Stock added successfully!");
                nameField.clear();
                dateField.clear();
                priceField.clear();
            } else {
                statusLabel.setText("❌ Failed to add stock.");
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("❌ Price must be a number.");
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setText("❌ Error: " + e.getMessage());
        }
    }

    // ✅ Navigation to View Stocks
    @FXML
    private void onGoStocks() {
        SceneManager.switchScene((Stage) nameField.getScene().getWindow(), "test_stock_list.fxml", "View Stocks");
    }

    // ✅ Navigation to Home
    @FXML
    private void onGoHome() {
        SceneManager.switchScene((Stage) nameField.getScene().getWindow(), "main.fxml", "Home");
    }
}
