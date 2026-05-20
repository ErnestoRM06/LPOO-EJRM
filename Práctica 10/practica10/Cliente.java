package practica10;

import java.util.ArrayList;

public class Cliente{
    private String nombre;
    private ArrayList<Producto> productos;
    private float total;

    public Cliente(String nombre) {
        this.nombre = nombre;
        productos = new ArrayList<>();
    }

    public void calcularTotal() {
        total = 0;
        productos.forEach((producto) -> {
            total += producto.getPrecio();
            System.out.println("Se agregó el producto " + producto + " al cliente " + nombre);
            Registro log = new Registro("log_clientes.csv");
            log.log("Se agregó el producto " + producto + " al cliente " + nombre);
        });
    }
    
    public void agregarProducto(Producto agregar) {
        productos.add(agregar);
    }

    public String getNombre() {
        return nombre;
    }

    public float getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Cliente " + nombre + ". Pago total: $" + total;
    }
}