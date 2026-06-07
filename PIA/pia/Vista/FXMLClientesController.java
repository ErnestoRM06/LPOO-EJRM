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
import pia.Controlador.CRUDClientes;
import pia.Modelo.IngresarDatosException;
import pia.Modelo.Nexo;

public class FXMLClientesController implements Initializable {

    @FXML
    private TableView<CRUDClientes> tablaClientes;
    @FXML
    private TableColumn<CRUDClientes, String> columnaID;
    @FXML
    private TableColumn<CRUDClientes, String> columnaNombre;
    @FXML
    private TableColumn<CRUDClientes, String> columnaTelefono;
    @FXML
    private TableColumn<CRUDClientes, String> columnaMembresia;
    @FXML
    private TableColumn<CRUDClientes, String> columnaTiempo;
    @FXML
    private TableColumn<CRUDClientes, String> columnaEliminar;
    @FXML
    private TextField textoBuscar;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonRegresar;
    @FXML
    private TextField textoID;
    @FXML
    private TextField textoNombre;
    @FXML
    private TextField textoTelefono;
    @FXML
    private TextField textoMembresia;
    @FXML
    private TextField textoDuracion;

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
            Nexo.stageClientes.close();
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
        textoTelefono.setTextFormatter(
                new TextFormatter<>(change
                        -> change.getControlNewText().matches("\\d*")
                ? change
                : null
                )
        );
        textoMembresia.setTextFormatter(
                new TextFormatter<>(change
                        -> change.getControlNewText().matches("\\d*")
                ? change
                : null
                )
        );
        textoDuracion.setTextFormatter(
                new TextFormatter<>(change
                        -> change.getControlNewText().matches("\\d*")
                ? change
                : null
                )
        );

        columnaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaID.setStyle("-fx-aligment: CENTER-LEFT");
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaNombre.setStyle("-fx-aligment: CENTER-LEFT");
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnaTelefono.setStyle("-fx-aligment: CENTER-LEFT");
        columnaMembresia.setCellValueFactory(new PropertyValueFactory<>("membresia"));
        columnaMembresia.setStyle("-fx-aligment: CENTER-LEFT");
        columnaTiempo.setCellValueFactory(new PropertyValueFactory<>("diasRestantes"));
        columnaTiempo.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEliminar.setCellValueFactory(new PropertyValueFactory<>("botonEliminar"));
        columnaEliminar.setStyle("-fx-aligment: CENTER");

        Callback<TableColumn<CRUDClientes, String>, TableCell<CRUDClientes, String>> construirColumnaEliminar = (param) -> {
            final TableCell<CRUDClientes, String> celda = new TableCell<CRUDClientes, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        botonEliminar = crearBoton("Eliminar registro.");
                        botonEliminar.setOnAction((event) -> {
                            //Aqui va el código del botón
                            CRUDClientes cliente = getTableView().getItems().get(getIndex());
                            Nexo.gimnasio.oClientes.remove(cliente);
                        });
                        setGraphic(botonEliminar);
                        setText(null);
                    }
                }
            };
            return celda;
        };
        columnaEliminar.setCellFactory(construirColumnaEliminar);

        Nexo.gimnasio.fClientes = new FilteredList<>(Nexo.gimnasio.oClientes, b -> true);

        textoBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            Nexo.gimnasio.fClientes.setPredicate(cliente -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (cliente.getId().toLowerCase().indexOf(lowerCaseFilter) != -1 || cliente.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1 || cliente.getMembresia().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });
        });

        Nexo.gimnasio.sClientes = new SortedList<>(Nexo.gimnasio.fClientes);

        Nexo.gimnasio.sClientes.comparatorProperty().bind(tablaClientes.comparatorProperty());

        tablaClientes.setItems(Nexo.gimnasio.sClientes);
    }

    @FXML
    private void botonAgregar(ActionEvent event) {
        if (!"".equals(textoID.getText().trim()) && !"".equals(textoNombre.getText().trim()) && !"".equals(textoTelefono.getText().trim()) && !"".equals(textoMembresia.getText().trim()) && !"".equals(textoDuracion.getText().trim())) {
            boolean existe = false;
            try {
                for (CRUDClientes cliente : Nexo.gimnasio.oClientes) {
                    if (cliente.getId().equals(textoID.getText().trim())) {
                        existe = true;
                        cliente.setNombre(textoNombre.getText().trim());
                        cliente.setTelefono(textoTelefono.getText().trim());
                        cliente.setMembresia(textoMembresia.getText().trim());
                        cliente.setFin(textoDuracion.getText().trim());

                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("FXMLClientes.fxml"));

                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();

                            Nexo.stageClientes.close();
                            Nexo.stageClientes = stage;

                        } catch (IOException ex) {
                            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                if (!existe) {
                    Nexo.gimnasio.oClientes.add(new CRUDClientes(textoID.getText().trim(), textoNombre.getText().trim(), textoTelefono.getText().trim(), textoMembresia.getText().trim(), textoDuracion.getText().trim()));
                }

                double descuento = calcularDescuento(textoMembresia.getText().trim(), textoDuracion.getText().trim());
                double pago = calcularPago(textoMembresia.getText().trim(), textoDuracion.getText().trim(), descuento);

                Nexo.gimnasio.total += pago;

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Se ha realizado la transacción");
                alerta.setTitle("Hecho!");
                alerta.setContentText("Se compró la membresia " + textoMembresia.getText().trim() + " por $" + pago + ", aplicandole un " + descuento + "% de descuento.");
                alerta.showAndWait();

            } catch (IngresarDatosException e) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Error al ingresar datos");
                alerta.setTitle("Advertencia!");
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            }

            textoID.setText("");
            textoNombre.setText("");
            textoTelefono.setText("");
            textoMembresia.setText("");
            textoDuracion.setText("");
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

    private double calcularDescuento(String membresia, String dias) {
        if (membresia.equals("1")) {
            if (Integer.parseInt(dias) > 20) {
                return 0.1;
            } else {
                if (Integer.parseInt(dias) > 10) {
                    return 0.05;
                }
            }
        } else {
            if (Integer.parseInt(dias) > 20) {
                return 0.3;
            } else {
                if (Integer.parseInt(dias) > 10) {
                    return 0.15;
                }
            }
        }
        return 0;
    }

    private double calcularPago(String membresia, String dias, double descuento) {
        if (membresia.equals("1")) {
            return (50 + 5 * Integer.parseInt(dias)) * (1 - descuento);
        } else {
            return (100 + 7 * Integer.parseInt(dias)) * (1 - descuento);
        }
    }
}
