package org.example.assignment_three;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SeatingArrangementApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SeatingArrangementApplication.class.getResource("SeatingLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Georgian Class Seat Arrangement");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}