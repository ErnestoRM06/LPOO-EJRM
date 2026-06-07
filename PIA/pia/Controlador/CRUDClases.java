package pia.Controlador;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import pia.Modelo.IngresarDatosException;

public class CRUDClases implements Serializable {

    private String evento;
    private String fecha;
    
    private LocalDate dia;

    public CRUDClases(String evento, String fecha) throws IngresarDatosException {
        this.evento = evento;
        if (!fechaValida(fecha)) {
            throw new IngresarDatosException("Fecha no válida.");
        }
        if(fechaPasada(dia)) {
            throw new IngresarDatosException("Fecha no válida, ingrese una actual o futura.");
        }
        this.fecha = fecha;
    }

    public String getEvento() {
        return evento;
    }

    public String getFecha() {
        if(fechaPasada(dia)) {
            fecha = "Acabada: " + fecha;
        }
        return fecha;
    }

    public LocalDate getDia() {
        return dia;
    }
    
    public boolean fechaPasada(LocalDate dia) {
        long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), dia);
        return diasRestantes < 0;
    }

    public boolean fechaValida(String fecha) {
        try {
            dia = LocalDate.parse(fecha);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
