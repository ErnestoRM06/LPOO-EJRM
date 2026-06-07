package pia.Modelo;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pia.Vista.*;

public class PIA extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/pia/Vista/FXMLPrincipal.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        Nexo.stagePrincipal = stage;

    }

    public static void main(String[] args) {
        Nexo.gimnasio = new Gimnasio();
        launch(args);
    }

}
