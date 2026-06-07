package pia.Controlador;

import java.io.Serializable;

public class CRUDEquipo implements Serializable {
    private String nombre;
    private String estado;
    
    private boolean enMantenimiento;

    public CRUDEquipo(String nombre) {
        this.nombre = nombre;
        estado = "Perfecto";
        enMantenimiento = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }
    public boolean isEnMantenimiento() {
        return enMantenimiento;
    }

    public void cambiarEstado() {
        if(enMantenimiento) {
            enMantenimiento = false;
            estado = "Perfecto";
        } else {
            enMantenimiento = true;
            estado = "En mantenimiento";
        }
        
    }
    
    
    
}
