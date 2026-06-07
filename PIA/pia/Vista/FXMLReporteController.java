package pia.Vista;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pia.Controlador.CRUDClientes;
import pia.Modelo.GeneradorReportes;
import pia.Modelo.GenerarArchivosException;
import pia.Modelo.Nexo;

public class FXMLReporteController implements Initializable {

    @FXML
    private Label textoClientes;
    @FXML
    private Label textoVencidas;
    @FXML
    private Label textoIngresos;
    @FXML
    private Label textoHoy;
    @FXML
    private Button botonImprimir;
    @FXML
    private Button botonRegresar;
    @FXML
    private TextField ItextoArchivo;

    int clientesTotales;
    int membresiasVencidas;
    int accesosHoy;
    float ingresoTotal;

    @FXML
    private void regresar(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stagePrincipal = stage;
            Nexo.stageReporte.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientesTotales = Nexo.gimnasio.oClientes.size();
        membresiasVencidas = 0;
        accesosHoy = Nexo.gimnasio.fAccesosHoy.size();
        ingresoTotal = Nexo.gimnasio.total;

        for (CRUDClientes cliente : Nexo.gimnasio.oClientes) {
            if (ChronoUnit.DAYS.between(LocalDate.now(), cliente.getFin()) < 0) {
                membresiasVencidas++;
            }
        }

        textoClientes.setText(clientesTotales + "");
        textoVencidas.setText(membresiasVencidas + "");
        textoHoy.setText(accesosHoy + "");
        textoIngresos.setText(ingresoTotal + "");
    }

    @FXML
    private void imprimir(ActionEvent event) {
        String archivo = ItextoArchivo.getText().trim();

        new Thread(() -> {
            try {
                GeneradorReportes.generarReportePDF(archivo, clientesTotales, membresiasVencidas, ingresoTotal, accesosHoy);
            } catch (GenerarArchivosException e) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Error al generar reporte");
                alerta.setTitle("Advertencia!");
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            }
        }).start();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("Se creó el reporte correctamente");
        alerta.setTitle("Aviso!");
        alerta.setContentText("Se creó el archivo " + archivo + ".pdf");
        alerta.showAndWait();
        
        ItextoArchivo.setText("");
    }

}
