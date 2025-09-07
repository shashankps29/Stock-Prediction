package application;

import application.dao.StockDAO;
import application.model.StockData;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestStockList extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<StockData> table = new TableView<>();

        TableColumn<StockData, String> nameCol = new TableColumn<>("Stock Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("stockName"));

        TableColumn<StockData, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<StockData, Double> priceCol = new TableColumn<>("Closing Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("closingPrice"));

        table.getColumns().addAll(nameCol, dateCol, priceCol);

        // ✅ Use the correct method name
        StockDAO stockDAO = new StockDAO();
        ObservableList<StockData> data = FXCollections.observableArrayList(stockDAO.getAllStockData());
        table.setItems(data);

        VBox root = new VBox(table);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Stock List Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
