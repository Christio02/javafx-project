package airlinemanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

    /**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(final Stage primaryStage) throws IOException {
        primaryStage.setTitle("Airline booking!");     
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("App.fxml")));
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm()); // sets the style sheet
        primaryStage.setScene(scene);

        primaryStage.show();


    }

    public static void main(final String[] args) {
        Application.launch(args);

    }

}