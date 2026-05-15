package practica06;

public abstract class Carta {
    
    protected String nombre;
    protected String descripcion;
    
    public void colocar() {
        System.out.println("Se colocó la carta " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract void mostrarDescripcion();
    
}
