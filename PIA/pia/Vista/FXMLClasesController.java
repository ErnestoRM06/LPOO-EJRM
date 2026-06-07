package pia.Vista;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import pia.Controlador.CRUDClases;
import pia.Modelo.IngresarDatosException;
import pia.Modelo.Nexo;

public class FXMLClasesController implements Initializable {

    @FXML
    private TextField textoEvento;
    @FXML
    private TextField textoFecha;
    @FXML
    private TableView<CRUDClases> tablaEventos;
    @FXML
    private TableColumn<CRUDClases, String> columnaEvento;
    @FXML
    private TableColumn<CRUDClases, String> columnaFecha;
    @FXML
    private TableColumn<CRUDClases, String> columnaEliminar;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonRegresar;

    private Button botonEliminar;

    @FXML
    private void regresar(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stagePrincipal = stage;
            Nexo.stageClases.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnaEvento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        columnaEvento.setStyle("-fx-aligment: CENTER-LEFT");
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaFecha.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEliminar.setCellValueFactory(new PropertyValueFactory<>("botonEliminar"));
        columnaEliminar.setStyle("-fx-aligment: CENTER");

        Callback<TableColumn<CRUDClases, String>, TableCell<CRUDClases, String>> construirColumnaEliminar = (param) -> {
            final TableCell<CRUDClases, String> celda = new TableCell<CRUDClases, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        botonEliminar = crearBoton("Eliminar registro.");
                        botonEliminar.setOnAction((event) -> {
                            //Aqui va el código del botón
                            CRUDClases clases = getTableView().getItems().get(getIndex());
                            Nexo.gimnasio.oClases.remove(clases);
                        });
                        setGraphic(botonEliminar);
                        setText(null);
                    }
                }
            };
            return celda;
        };
        columnaEliminar.setCellFactory(construirColumnaEliminar);

        Nexo.gimnasio.sClases = new SortedList<>(Nexo.gimnasio.oClases);
        Nexo.gimnasio.sClases.comparatorProperty().bind(tablaEventos.comparatorProperty());
        tablaEventos.setItems(Nexo.gimnasio.sClases);
    }

    @FXML
    private void botonAgregar(ActionEvent event) {
        if (!"".equals(textoEvento.getText().trim()) && !"".equals(textoFecha.getText().trim())) {
            try {
                Nexo.gimnasio.oClases.add(new CRUDClases(textoEvento.getText(), textoFecha.getText().trim()));
                
            } catch (IngresarDatosException e) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Error al ingresar datos");
                alerta.setTitle("Advertencia!");
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            }

            textoEvento.setText("");
            textoFecha.setText("");
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Error al ingresar datos");
            alerta.setTitle("Advertencia!");
            alerta.setContentText("Es necesario que los cuadros de texto no esten vacios.");
            alerta.showAndWait();
        }

    }

    private Button crearBoton(String toolTip) {
        Button boton = new Button();
        boton.setTooltip(new Tooltip(toolTip));
        boton.setText("X");
        return boton;
    }
}
