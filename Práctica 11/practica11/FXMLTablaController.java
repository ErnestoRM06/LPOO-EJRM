package practica11;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class FXMLTablaController implements Initializable {

    @FXML
    private TextField txtCliente;
    @FXML
    private TextFieldFloat txtTotal;
    @FXML
    private TextField txtFecha;
    @FXML
    private BotonAzul botonAgregar;
    @FXML
    private TableView<CRUDCliente> tablaRegistro;
    @FXML
    private TableColumn<CRUDCliente, String> columnaFecha;
    @FXML
    private TableColumn<CRUDCliente, String> columnaCliente;
    @FXML
    private TableColumn<CRUDCliente, String> columnaTotal;
    @FXML
    private TableColumn<CRUDCliente, String> columnaEliminar;
    @FXML
    private Text lblFilter;
    @FXML
    private TextField txtFilter;

    private Button botonEliminar;
    private ObservableList<CRUDCliente> clientes = FXCollections.observableArrayList();
    private FilteredList<CRUDCliente> filteredData;
    private SortedList<CRUDCliente> sortedData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaFecha.setStyle("-fx-aligment: CENTER-LEFT");
        columnaCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCliente.setStyle("-fx-aligment: CENTER-LEFT");
        columnaTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        columnaTotal.setStyle("-fx-aligment: CENTER-LEFT");
        columnaEliminar.setCellValueFactory(new PropertyValueFactory<>("botonEliminar"));
        columnaEliminar.setStyle("-fx-aligment: CENTER");

        Callback<TableColumn<CRUDCliente, String>, TableCell<CRUDCliente, String>> construirColumnaEliminar = (param) -> {
            final TableCell<CRUDCliente, String> celda = new TableCell<CRUDCliente, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        botonEliminar = crearBoton("Eliminar registro.");
                        botonEliminar.setOnAction((event) -> {
                            //Aqui va el código del botón
                            CRUDCliente cliente = getTableView().getItems().get(getIndex());
                            clientes.remove(cliente);
                        });
                        setGraphic(botonEliminar);
                        setText(null);
                    }
                }
            };
            return celda;
        };
        columnaEliminar.setCellFactory(construirColumnaEliminar);

        lblFilter.setText("Buscar por fecha: ");

        filteredData = new FilteredList<>(clientes, b -> true);

        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cliente -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (cliente.getFecha().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });
        });

        sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tablaRegistro.comparatorProperty());

        tablaRegistro.setItems(sortedData);

        botonAgregar.setOnMouseEntered(e -> {
            botonAgregar.setStyle("-fx-background-color: blue;");
        });

        botonAgregar.setOnMouseExited(e -> {
            botonAgregar.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        });
    }

    @FXML
    private void botonAgregar(ActionEvent event) {
        if (!"".equals(txtFecha.getText().trim()) && !"".equals(txtCliente.getText().trim()) && !"".equals(txtTotal.getText().trim())) {
            clientes.add(new CRUDCliente(txtCliente.getText().trim(), txtFecha.getText().trim(), txtTotal.getText().trim()));

            txtCliente.setText("");
            txtFecha.setText("");
            txtTotal.setText("");
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
