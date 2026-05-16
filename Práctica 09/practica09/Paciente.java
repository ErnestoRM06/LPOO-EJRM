package practica09;

import java.io.Serializable;

public class Paciente implements Serializable {
    private String nombre;
    private String telefono;
    private String tipoSangre;

    public Paciente(String nombre, String telefono, String tipoSangre){
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
    }

    @Override
    public String toString() {
        return "Paciente " + nombre + ". Telefono: " + telefono + ". Tipo de sangre: " + tipoSangre;
    }
    
}
