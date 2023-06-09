package airlinemanager;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


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
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // sets the style sheet
        primaryStage.setScene(scene);

        primaryStage.show();


    }

     public static void main(final String[] args) {
        Application.launch(args);

    }
}