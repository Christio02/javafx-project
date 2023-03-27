package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.awt.MouseInfo;
javafx.geometry.Point2D



public class PopupUtil {

    /**
     * Creates a popup at the current mouse location
     * 
     * @param <T>                The type of the controller of the popup
     * @param file               The path to the FXML file of the popup, should be
     *                           absolute (not relative), e. g.
     *                           "exampleproject/Popup.fxml"
     * @param stage              The stage to display the popup on
     * @param controllerConsumer A function to run on the created popup and
     *                           controller
     */
    public static <T> void createPopup(String file, Stage stage, BiConsumer<PopupUtil, T> controllerConsumer) {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        createPopup(file, mouseLocation.getX(), mouseLocation.getY(), stage, controllerConsumer);
    }

    /**
     * Creates a popup at the given location
     * 
     * @param <T>                The type of the controller of the popup
     * @param file               The path to the FXML file of the popup, should be
     *                           absolute (not relative), e. g.
     *                           "exampleproject/Popup.fxml"
     * @param x                  The x coordinate
     * @param y                  The y coordinate
     * @param stage              The stage to display the popup on
     * @param controllerConsumer A function to run on the created popup and
     *                           controller
     */
    public static <T> void createPopup(String file, double x, double y, Stage stage,
        BiConsumer<PopupUtil, T> controllerConsumer) {
        PopupUtil popup = new PopupUtil();

        ClassLoader classLoader = PopupUtil.class.getClassLoader();
        FXMLLoader loader = new FXMLLoader(classLoader.getResource(file));

        AnchorPane pane;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        pane.setStyle("-fx-background-color: #fafffb; " +
                "-fx-background-insets: 10; " +
                "-fx-effect: dropshadow(three-pass-box, #000000, 5, 0, 0, 0);");

        T controller = loader.getController();
        controllerConsumer.accept(popup, controller);

        if (controller instanceof StageContainer) {
            ((StageContainer) controller).setStage(stage);
        }

        popup.getContent().add(pane);

        popup.setX(x);
        popup.setY(y);

        popup.setAutoHide(true);
        popup.show(stage);
    }
}


    
}
