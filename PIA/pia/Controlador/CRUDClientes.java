package pia.Controlador;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import pia.Modelo.IngresarDatosException;

public class CRUDClientes implements Serializable {

    private String id;
    private String nombre;
    private String telefono;
    private String membresia;
    private String diasRestantes;
    
    private LocalDate Fin;

    public CRUDClientes(String ID, String Nombre, String Telefono, String Membresia, String Agregar) throws IngresarDatosException {
        id = ID;
        nombre = Nombre;
        if (Telefono.length() != 10) {
            throw new IngresarDatosException("Telefono no válido");
        }
        telefono = Telefono;
        if (Membresia.equals("1")) {
            membresia = "Basica";
        } else {
            if (Membresia.equals("2")) {
                membresia = "Premium";
            } else {
                throw new IngresarDatosException("Membresia no válida");
            }
        }
        Fin = LocalDate.now().plusDays(Integer.parseInt(Agregar));
        if (Agregar.equals("0")) {
            throw new IngresarDatosException("Dias de duración de la membresia no válida");
        }
        diasRestantes = Agregar;
    }

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        id = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) throws IngresarDatosException {
        if (Telefono.length() != 10) {
            throw new IngresarDatosException("Telefono no válido");
        }
        this.telefono = Telefono;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String Membresia) throws IngresarDatosException {
        if (Membresia.equals("1")) {
            membresia = "Basica";
        } else {
            if (Membresia.equals("2")) {
                membresia = "Premium";
            } else {
                throw new IngresarDatosException("Membresia no válida");
            }
        }
    }

    public LocalDate getFin() {
        return Fin;
    }

    public void setFin(String Agregar) throws IngresarDatosException {
        if (Agregar.equals("0")) {
            throw new IngresarDatosException("Dias de duración de la membresia no válida");
        }
        Fin = LocalDate.now().plusDays(Integer.parseInt(Agregar));
        diasRestantes = Agregar;
    }

    public String getDiasRestantes() {
        calcularTiempo();
        return diasRestantes;
    }
    
    public void calcularTiempo() {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), Fin);

        if (dias < 0) {
            diasRestantes = "Vencida";
        } else {
            if (dias == 0) {
                diasRestantes = "Hoy";
            } else {
                diasRestantes = "" + dias;
            }
        }
    }
}
