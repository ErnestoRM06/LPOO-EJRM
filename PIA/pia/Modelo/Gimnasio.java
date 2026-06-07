package pia.Modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import pia.Controlador.CRUDAsistencia;
import pia.Controlador.CRUDClases;
import pia.Controlador.CRUDClientes;
import pia.Controlador.CRUDEquipo;

public class Gimnasio {
    public ObservableList<CRUDClientes> oClientes = FXCollections.observableArrayList();
    public FilteredList<CRUDClientes> fClientes;
    public SortedList<CRUDClientes> sClientes;
    
    public ObservableList<CRUDClases> oClases = FXCollections.observableArrayList();
    public SortedList<CRUDClases> sClases;

    public ObservableList<CRUDEquipo> oEquipo = FXCollections.observableArrayList();
    public SortedList<CRUDEquipo> sEquipo;
    
    public ObservableList<CRUDAsistencia> oAsistencia = FXCollections.observableArrayList();
    public FilteredList<CRUDAsistencia> fAsistencia;
    public SortedList<CRUDAsistencia> sAsistencia;
    
    public FilteredList<CRUDAsistencia> fAccesosHoy;
    public SortedList<CRUDAsistencia> sAccesosHoy;
    
    public float total = 0;
    
    public String calcularEquipos() {
        int contador = 0;
        
        contador = oEquipo.stream().filter((equipo) -> (!equipo.isEnMantenimiento())).map((_item) -> 1).reduce(contador, Integer::sum);
        return contador + "";
    }
    
    public String eventoHoy() {
        for(CRUDClases clase : Nexo.gimnasio.oClases) {
            long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), clase.getDia());
            if(diasRestantes == 0) {
                return clase.getEvento();
            }
        }
        return "No hay clase hoy.";
    }
    
}
