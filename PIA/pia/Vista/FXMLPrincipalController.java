package pia.Vista;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pia.Controlador.CRUDAsistencia;
import pia.Modelo.Nexo;

public class FXMLPrincipalController implements Initializable {

    @FXML
    private Label textoClase;
    @FXML
    private Label textoMaquinaria;
    @FXML
    private TableView<CRUDAsistencia> tablaHoy;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaCliente;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaEntrada;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaSalida;
    @FXML
    private Button botonClientes;
    @FXML
    private Button botonAsistencia;
    @FXML
    private Button botonEquipo;
    @FXML
    private Button botonReporte;
    @FXML
    private Button botonClases;
    @FXML
    private Button botonBackUp;

    @FXML
    private void abrirClientes(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLClientes.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stageClientes = stage;
            Nexo.stagePrincipal.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirEquipo(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLEquipo.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stageEquipo = stage;
            Nexo.stagePrincipal.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirReporte(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLReporte.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stageReporte = stage;
            Nexo.stagePrincipal.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirClases(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLClases.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stageClases = stage;
            Nexo.stagePrincipal.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirAsistencia(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLAsistencia.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stageAsistencia = stage;
            Nexo.stagePrincipal.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void abrirBackUp(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLBackUp.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stageBackUp = stage;
            Nexo.stagePrincipal.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String equipo = Nexo.gimnasio.calcularEquipos();
        String clase = Nexo.gimnasio.eventoHoy();

        if (equipo == null) {
            textoMaquinaria.setText("0");
        } else {
            textoMaquinaria.setText(equipo);
        }

        if (clase == null) {
            textoClase.setText("No hay clase hoy.");
        } else {
            textoClase.setText(clase);
        }
        
        columnaCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCliente.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        columnaEntrada.setStyle("-fx-aligment: CENTER-LEFT");
        columnaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        columnaSalida.setStyle("-fx-aligment: CENTER-LEFT");

        Nexo.gimnasio.fAccesosHoy = new FilteredList<>(Nexo.gimnasio.oAsistencia);

        LocalDate hoy = LocalDate.now();

        Nexo.gimnasio.fAccesosHoy.setPredicate(acceso
                -> acceso.getDiaLD()
                        .equals(hoy)
        );

        Nexo.gimnasio.sAccesosHoy = new SortedList<>(Nexo.gimnasio.fAccesosHoy);
        Nexo.gimnasio.sAccesosHoy.comparatorProperty().bind(tablaHoy.comparatorProperty());
        tablaHoy.setItems(Nexo.gimnasio.sAccesosHoy);
    }

}
