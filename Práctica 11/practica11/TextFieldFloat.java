package practica11;

import javafx.scene.control.TextField;

public class TextFieldFloat extends TextField {

    public TextFieldFloat() {
        textProperty().addListener((obs, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}
