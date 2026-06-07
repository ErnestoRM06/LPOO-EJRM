package pia.Vista;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import pia.Controlador.CRUDAsistencia;
import pia.Modelo.IngresarDatosException;
import pia.Modelo.Nexo;

public class FXMLAsistenciaController implements Initializable {

    @FXML
    private TextField textoID;
    @FXML
    private TextField textoEntrada;
    @FXML
    private TextField textoSalida;
    @FXML
    private TableView<CRUDAsistencia> tablaRegistros;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaCliente;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaEntrada;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaSalida;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaDia;
    @FXML
    private TableColumn<CRUDAsistencia, String> columnaEliminar;
    @FXML
    private TextField textoDia;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonRegresar;
    @FXML
    private TextField textoBuscar;

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
            Nexo.stageAsistencia.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textoID.setTextFormatter(
                new TextFormatter<>(change
                        -> change.getControlNewText().matches("\\d*")
                ? change
                : null
                )
        );
        
        columnaCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCliente.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        columnaEntrada.setStyle("-fx-aligment: CENTER-LEFT");
        columnaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        columnaSalida.setStyle("-fx-aligment: CENTER-LEFT");
        columnaDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
        columnaDia.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEliminar.setCellValueFactory(new PropertyValueFactory<>("botonEliminar"));
        columnaEliminar.setStyle("-fx-aligment: CENTER");
        
        Callback<TableColumn<CRUDAsistencia, String>, TableCell<CRUDAsistencia, String>> construirColumnaEliminar = (param) -> {
            final TableCell<CRUDAsistencia, String> celda = new TableCell<CRUDAsistencia, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        botonEliminar = crearBoton("Eliminar registro.");
                        botonEliminar.setOnAction((event) -> {
                            //Aqui va el código del botón
                            CRUDAsistencia registro = getTableView().getItems().get(getIndex());
                            Nexo.gimnasio.oAsistencia.remove(registro);
                        });
                        setGraphic(botonEliminar);
                        setText(null);
                    }
                }
            };
            return celda;
        };
        columnaEliminar.setCellFactory(construirColumnaEliminar);
        
        Nexo.gimnasio.fAsistencia = new FilteredList<>(Nexo.gimnasio.oAsistencia, b -> true);

        textoBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            Nexo.gimnasio.fAsistencia.setPredicate(registro -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (registro.getCliente().getId().toLowerCase().indexOf(lowerCaseFilter) != -1 || registro.getDia().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });
        });

        Nexo.gimnasio.sAsistencia = new SortedList<>(Nexo.gimnasio.fAsistencia);

        Nexo.gimnasio.sAsistencia.comparatorProperty().bind(tablaRegistros.comparatorProperty());

        tablaRegistros.setItems(Nexo.gimnasio.sAsistencia);
    }    
    
    @FXML
    private void botonAgregar(ActionEvent event) {
        if (!"".equals(textoID.getText().trim()) && !"".equals(textoEntrada.getText().trim()) && !"".equals(textoSalida.getText().trim()) && !"".equals(textoDia.getText().trim())) {
            try {
                Nexo.gimnasio.oAsistencia.add(new CRUDAsistencia(textoID.getText().trim(), textoEntrada.getText().trim(), textoSalida.getText().trim(), textoDia.getText().trim()));
                
            } catch (IngresarDatosException e) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Error al ingresar datos");
                alerta.setTitle("Advertencia!");
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            }

            textoID.setText("");
            textoEntrada.setText("");
            textoSalida.setText("");
            textoDia.setText("");
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
