package airlinemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(final Stage primaryStage) throws IOException {
        primaryStage.setTitle("Airline booking!");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/App.fxml"))));
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch(args);
    }

}