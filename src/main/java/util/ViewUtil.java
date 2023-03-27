package util;

import java.io.IOException;
import java.util.function.Consumer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewUtil {

    /**
     * Switches the entire view to a different one. Useful if your application has
     * multiple different pages or similar.
     * <p>
     * Note that this will not reuse (or keep a reference to) the old controllers!
     * Make sure to do that on your own if the contain some important state!
     * 
     * @param <T>                The type of the controller of the new view
     * @param file               The path to the FXML file of the popup, should be
     *                           absolute (not relative), e. g.
     *                           "exampleproject/Popup.fxml"
     * @param stage              The stage to display the popup on
     * @param controllerConsumer Some function to run on the controller of the new
     *                           view
     */
    public static <T> void switchView(String file, Stage stage, Consumer<T> controllerConsumer) {
        ClassLoader classLoader = PopupUtil.class.getClassLoader();
        FXMLLoader loader = new FXMLLoader(classLoader.getResource(file));

        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        T controller = loader.getController();
        controllerConsumer.accept(controller);

        if (controller instanceof StageContainer) {
            ((StageContainer) controller).setStage(stage);
        }
    }
}

