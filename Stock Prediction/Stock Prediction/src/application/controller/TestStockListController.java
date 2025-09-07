package application.controller;

import application.dao.StockDAO;
import application.model.StockData;
import application.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TestStockListController {

    @FXML
    private TableView<StockData> stockTable;

    @FXML
    private TableColumn<StockData, String> nameCol;

    @FXML
    private TableColumn<StockData, String> dateCol;

    @FXML
    private TableColumn<StockData, Double> priceCol;

    private final StockDAO stockDAO = new StockDAO();

    @FXML
    private void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("stockName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("closingPrice"));
    }

    @FXML
    private void onLoadData() {
        ObservableList<StockData> data = FXCollections.observableArrayList(stockDAO.getAllStockData());
        stockTable.setItems(data);
    }

    // 🔽 Navigation Buttons

    @FXML
    private void onAddStock() {
        SceneManager.switchScene((Stage) stockTable.getScene().getWindow(), "add_stock.fxml", "Add Stock");
    }

    @FXML
    private void onPredict() {
        SceneManager.switchScene((Stage) stockTable.getScene().getWindow(), "predict.fxml", "Price Prediction");
    }

    @FXML
    private void onGoHome() {
        SceneManager.switchScene((Stage) stockTable.getScene().getWindow(), "main.fxml", "Home");
    }
}
