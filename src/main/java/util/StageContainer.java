package util;

import javafx.stage.Stage;

/**
 * For å bytte mellom views eller legge til en popup trenger vi en referanse til
 * "primaryStage". Denne klassen lar oss gjenbruke logikk for å lagre en
 * referanse til denne, og også gjør at vi kan sjekke om noe er en instans av
 * denne klassen for å enkelt (og automatisk) oppdatere denne referansen
 */
public abstract class StageContainer {

    private Stage stage;

    public Stage getStage() {
        if (this.stage == null) {
            /*
             * Istedenfor å jakte ned en null-pointer en eller annen plass får vi her en mye
             * tidligere error som også forteller oss hva problemet er!
             */
            throw new IllegalStateException("Stage isn't set yet!");
        }

        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
