package pia.Controlador;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import pia.Modelo.IngresarDatosException;
import pia.Modelo.Nexo;

public class CRUDAsistencia implements Serializable {
    private String nombre;
    private String horaEntrada;
    private String horaSalida;
    private String dia;
    
    private CRUDClientes cliente;
    private LocalDate diaLD;

    public CRUDAsistencia(String id, String horaEntrada, String horaSalida, String dia) throws IngresarDatosException {
        boolean encontrado = false;
        
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        if(!horaValida(horaEntrada)) {
            throw new IngresarDatosException("Hora inicial inválida.");
        }
        if(!horaValida(horaSalida)) {
            throw new IngresarDatosException("Hora final inválida.");
        }
        if(!horasValidas(horaEntrada, horaSalida)) {
            throw new IngresarDatosException("Hora inicial mayor a la hora final");
        }
        
        this.dia = dia;
        if(!fechaValida(dia)) {
            throw new IngresarDatosException("Fecha no válida.");
        }
        
        for(CRUDClientes buscar : Nexo.gimnasio.oClientes) {
            if (buscar.getId().equals(id)) {
                cliente = buscar;
                nombre = cliente.getNombre();
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new IngresarDatosException("No se encontró un cliente con el ID ingresado.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getDia() {
        return dia;
    }

    public CRUDClientes getCliente() {
        return cliente;
    }

    public LocalDate getDiaLD() {
        return diaLD;
    }
    
    public boolean horasValidas(String hEntrada, String hSalida) {
        long segundosRestantes = ChronoUnit.SECONDS.between(LocalTime.parse(hEntrada), LocalTime.parse(hSalida));
        return segundosRestantes > 0;
    }
    
    public boolean horaValida(String hora) {
        try {
            LocalTime h = LocalTime.parse(hora);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public boolean fechaValida(String fecha) {
        try {
            diaLD = LocalDate.parse(fecha);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
}
