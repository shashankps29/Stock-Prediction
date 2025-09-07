package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load your FXML here 👇
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/main.fxml"));

            Parent root = loader.load();

            // Set up the scene
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Stock Prediction System");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
