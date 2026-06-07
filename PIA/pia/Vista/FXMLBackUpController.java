package pia.Vista;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pia.Modelo.BackUp;
import pia.Modelo.GeneradorReportes;
import pia.Modelo.GenerarArchivosException;
import pia.Modelo.GenerarBackUp;
import pia.Modelo.Nexo;

public class FXMLBackUpController implements Initializable {

    @FXML
    private TextField textoRuta;
    @FXML
    private Button botonRegresar;
    @FXML
    private Button botonCrear;
    @FXML
    private Button botonCargar;

    @FXML
    private void regresar(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stagePrincipal = stage;
            Nexo.stageBackUp.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void cargar(ActionEvent event) {
        String archivo = textoRuta.getText().trim();
        
        GenerarBackUp generador = new GenerarBackUp(archivo);
        try {
            BackUp nuevo = generador.cargarObjeto();
            nuevo.cargarBackUp();
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Exito en cargar backup.");
            alerta.setTitle("Aviso!");
            alerta.setContentText("Se cargo el archivo " + archivo + ".dat");
            alerta.showAndWait();
        } catch (GenerarArchivosException e) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Error al cargar backup");
            alerta.setTitle("Advertencia!");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

    @FXML
    private void crear(ActionEvent event) {
        String archivo = textoRuta.getText().trim();

        GenerarBackUp generador = new GenerarBackUp(archivo);
        generador.start();
    }

}
