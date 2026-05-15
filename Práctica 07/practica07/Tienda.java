package practica07;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tienda {

    private ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarTarjeta(Tarjeta nuevo) {
        tarjetas.add(nuevo);
    }

    public void agregarProducto(Producto nuevo) {
        productos.add(nuevo);
    }

    public void comprarProducto(String producto, String clave) throws ClaveIncorrectaException, ProductoNoEncontradoException, SaldoInsuficienteException {
        Tarjeta usada = buscarTarjeta(clave);
        Producto comprar = buscarProducto(producto);
        
        if (usada.getSaldo() < comprar.getPrecio()) {
            throw new SaldoInsuficienteException("El saldo en la tarjeta de clave " + usada.getClave() + " no fue suficiente para pagar el producto " + comprar.getNombre() + "\nPrecio de producto: " + comprar.getPrecio() + ". Saldo de la tarjeta: " + usada.getSaldo());
        } else {
            usada.setSaldo(usada.getSaldo() - comprar.getPrecio());
            System.out.println("Se compro el producto " + comprar.getNombre() + " con la tarjeta de clave " + usada.getClave() + "\nPrecio de producto: " + comprar.getPrecio() + ". Saldo actual de la tarjeta: " + usada.getSaldo());
            productos.remove(comprar);
        }
    }

    public Tarjeta buscarTarjeta(String clave) throws ClaveIncorrectaException {
        for (Tarjeta tarjeta : tarjetas) {
            if (tarjeta.getClave().equals(clave)) {
                return tarjeta;
            }
        }
        throw new ClaveIncorrectaException("No existe tarjeta con la clave " + clave);

    }

    public Producto buscarProducto(String nombre) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException("No hay productos con el nombre " + nombre);

    }
    
    public void mostrarProductos() {
        productos.forEach((producto) -> {
            System.out.println(" - " + producto);
        });
    }
    
    public void logError(String mensaje) {
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.write(mensaje + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void procesarOperacion(String producto, String clave) {
        try {
            comprarProducto(producto, clave);
            System.out.println("Operación exitosa");
        } catch (ClaveIncorrectaException | ProductoNoEncontradoException | SaldoInsuficienteException e) {

            System.out.println("Se capto una excepción: " + e.getMessage());
            logError(e.getMessage());
        }
    }

}
