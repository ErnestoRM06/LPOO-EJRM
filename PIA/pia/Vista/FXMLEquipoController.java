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
import pia.Controlador.CRUDEquipo;
import pia.Modelo.Nexo;

public class FXMLEquipoController implements Initializable {

    @FXML
    private TextField textoEquipo;
    @FXML
    private TableView<CRUDEquipo> tablaEquipo;
    @FXML
    private TableColumn<CRUDEquipo, String> columnaEquipo;
    @FXML
    private TableColumn<CRUDEquipo, String> columnaEstado;
    @FXML
    private TableColumn<CRUDEquipo, String> columnaCambiar;
    @FXML
    private TableColumn<CRUDEquipo, String> columnaEliminar;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonRegresar;

    private Button botonEliminar;
    private Button botonCambiar;

    @FXML
    private void regresar(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Nexo.stagePrincipal = stage;
            Nexo.stageEquipo.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnaEquipo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaEquipo.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnaEstado.setStyle("-fx-aligment: CENTER-LEFT");
        columnaCambiar.setCellValueFactory(new PropertyValueFactory<>("botonCambiar"));
        columnaCambiar.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEliminar.setCellValueFactory(new PropertyValueFactory<>("botonEliminar"));
        columnaEliminar.setStyle("-fx-aligment: CENTER");

        Callback<TableColumn<CRUDEquipo, String>, TableCell<CRUDEquipo, String>> construirColumnaEliminar = (param) -> {
            final TableCell<CRUDEquipo, String> celda = new TableCell<CRUDEquipo, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        botonEliminar = crearBotonEliminar("Eliminar registro.");
                        botonEliminar.setOnAction((event) -> {
                            //Aqui va el código del botón
                            CRUDEquipo equipo = getTableView().getItems().get(getIndex());
                            Nexo.gimnasio.oEquipo.remove(equipo);
                        });
                        setGraphic(botonEliminar);
                        setText(null);
                    }
                }
            };
            return celda;
        };
        columnaEliminar.setCellFactory(construirColumnaEliminar);

        Callback<TableColumn<CRUDEquipo, String>, TableCell<CRUDEquipo, String>> construirColumnaCambiar = (param) -> {
            final TableCell<CRUDEquipo, String> celda = new TableCell<CRUDEquipo, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        botonCambiar = crearBotonCambiar("Cambiar estado del equipo.");
                        botonCambiar.setOnAction((event) -> {
                            //Aqui va el código del botón
                            CRUDEquipo equipo = getTableView().getItems().get(getIndex());
                            equipo.cambiarEstado();

                            try {
                                Parent root = FXMLLoader.load(getClass().getResource("FXMLEquipo.fxml"));

                                Scene scene = new Scene(root);
                                Stage stage = new Stage();
                                stage.setScene(scene);
                                stage.show();
                                
                                Nexo.stageEquipo.close();
                                Nexo.stageEquipo = stage;
                                
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                        setGraphic(botonCambiar);
                        setText(null);
                    }
                }
            };
            return celda;
        };
        columnaCambiar.setCellFactory(construirColumnaCambiar);
        
        Nexo.gimnasio.sEquipo = new SortedList<>(Nexo.gimnasio.oEquipo);
        Nexo.gimnasio.sEquipo.comparatorProperty().bind(tablaEquipo.comparatorProperty());
        tablaEquipo.setItems(Nexo.gimnasio.sEquipo);
    }

    @FXML
    private void botonAgregar(ActionEvent event) {
        if (!"".equals(textoEquipo.getText().trim())) {
            Nexo.gimnasio.oEquipo.add(new CRUDEquipo(textoEquipo.getText().trim()));

            textoEquipo.setText("");
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Error al ingresar datos");
            alerta.setTitle("Advertencia!");
            alerta.setContentText("Es necesario que los cuadros de texto no esten vacios.");
            alerta.showAndWait();
        }

    }

    private Button crearBotonEliminar(String toolTip) {
        Button boton = new Button();
        boton.setTooltip(new Tooltip(toolTip));
        boton.setText("X");
        return boton;
    }

    private Button crearBotonCambiar(String toolTip) {
        Button boton = new Button();
        boton.setTooltip(new Tooltip(toolTip));
        boton.setText("Cambiar estado");
        return boton;
    }
}
