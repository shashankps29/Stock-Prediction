package application.controller;

import application.dao.StockDataFetcher;
import application.utils.PredictLogic;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.List;

public class PredictionModule {

    public PredictionModule() {}

    @FXML
    private ComboBox<String> stockSelector;

    @FXML
    private Label predictionLabel;

    @FXML
    public void initialize() {
        List<String> stockNames = StockDataFetcher.getAllStockNames();
        stockSelector.getItems().addAll(stockNames);
    }

    @FXML
    public void onPredict() {
        String selectedStock = stockSelector.getValue();
        if (selectedStock == null) {
            predictionLabel.setText("⚠️ Please select a stock.");
            return;
        }

        List<Double> prices = StockDataFetcher.getHistoricalPrices(selectedStock);
        if (prices.size() < 2) {
            predictionLabel.setText("⚠️ Not enough data.");
            return;
        }

        double prediction = PredictLogic.predictNextPrice(prices);
        predictionLabel.setText("📈 Predicted Price: ₹" + String.format("%.2f", prediction));
    }
}
