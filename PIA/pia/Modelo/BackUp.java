package pia.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pia.Controlador.CRUDAsistencia;
import pia.Controlador.CRUDClases;
import pia.Controlador.CRUDClientes;
import pia.Controlador.CRUDEquipo;

public class BackUp implements Serializable{
    private ArrayList<CRUDClientes> clientes;
    private ArrayList<CRUDClases> clases;
    private ArrayList<CRUDEquipo> equipo;
    private ArrayList<CRUDAsistencia> asistencia;
    
    private float total;

    public BackUp(ObservableList<CRUDClientes> clientes, ObservableList<CRUDClases> clases, ObservableList<CRUDEquipo> equipo, ObservableList<CRUDAsistencia> asistencia, float total) {
        this.clientes = new ArrayList<>(clientes);
        this.clases = new ArrayList<>(clases);
        this.equipo = new ArrayList<>(equipo);
        this.asistencia = new ArrayList<>(asistencia);
        
        this.total = total;
    }
    
    public void cargarBackUp() {
        Nexo.gimnasio.oClientes = FXCollections.observableArrayList(clientes);
        Nexo.gimnasio.oClases = FXCollections.observableArrayList(clases);
        Nexo.gimnasio.oEquipo = FXCollections.observableArrayList(equipo);
        Nexo.gimnasio.oAsistencia = FXCollections.observableArrayList(asistencia);
        Nexo.gimnasio.total = total;
    }
}
