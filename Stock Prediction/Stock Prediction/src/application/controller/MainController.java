package application.controller;

import application.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button addButton;

    @FXML
    private void onAddStock() {
        SceneManager.switchScene((Stage) addButton.getScene().getWindow(), "add_stock.fxml", "Add Stock");
    }

    @FXML
    private void onViewStocks() {
        SceneManager.switchScene((Stage) addButton.getScene().getWindow(), "test_stock_list.fxml", "Stock List");
    }

    @FXML
    private void onPredict() {
        SceneManager.switchScene((Stage) addButton.getScene().getWindow(), "predict.fxml", "Price Prediction");
    }

    @FXML
    private void onExit() {
        System.exit(0);
    }
}
