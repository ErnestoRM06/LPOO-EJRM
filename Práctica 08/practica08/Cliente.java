package practica08;

import java.util.*;

public class Cliente {
    
    private ArrayList<Producto> productos;
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
        productos = new ArrayList<>();
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto agregar) {
        productos.add(agregar);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
