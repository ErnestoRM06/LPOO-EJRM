package practica08;

import java.util.*;
import java.util.stream.Collectors;

public class Tienda {
    private ArrayList<Producto> productos;
    private LinkedList<Cliente> filaClientes;
    private HashMap<String, String> empleados;
    private HashSet<String> marcas;
    
    public Tienda() {
        productos = new ArrayList<>();
        filaClientes = new LinkedList<>();
        empleados = new HashMap<>();
        marcas = new HashSet<>();
    }
    
    public void agregarProducto(Producto agregar) {
        productos.add(agregar);
        marcas.add(agregar.getMarca());
    }
    
    public Producto buscarProducto(String nombre) {
        return productos.stream().filter(producto -> producto.getNombre().equals(nombre)).findFirst().orElse(null);
    }
    
    public List<Producto> buscarPorMarca(String marca) {
        return productos.stream().filter(producto -> producto.getMarca().equalsIgnoreCase(marca)).collect(Collectors.toList());
    }
    
    public List<Producto> buscarPorMarcaYPrecio(String marca, float menorA) {
        return productos.stream().filter(producto -> producto.getMarca().equalsIgnoreCase(marca) && producto.getPrecio() <= menorA).collect(Collectors.toList());
    }
    
    public void agregarCliente(Cliente agregar) {
        filaClientes.add(agregar);
    }
    
    public void agregarProductoACliente(Producto agregar) {
        if (filaClientes.isEmpty()) {
            System.out.println("ERROR: no hay clientes en la fila.");
            return;
        }
        
        filaClientes.getFirst().agregarProducto(agregar);
        productos.remove(agregar);
    }
    
    public void cobrarCliente() {
        if (filaClientes.isEmpty()) {
            System.out.println("ERROR: no hay clientes en la fila.");
            return;
        }
        
        System.out.println("Cliente " + filaClientes.getFirst().getNombre());
        
        Iterator<Producto> iterador = filaClientes.poll().getProductos().iterator();
        float total = 0;
        
        while (iterador.hasNext()) {
            Producto actual = iterador.next();
            total += actual.getPrecio();
            
            System.out.println(actual);            
        }
        System.out.println("Total = $" + total);
    }
    
    public void registrarEmpleado(String nombre, String clave) {
        empleados.put(nombre, clave);
    }
    
    public String obtenerClave(String nombre) {
        return empleados.get(nombre);
    }
    
    public void mostrarMarcas() {
        marcas.forEach((marca) -> {System.out.println(marca);
        });
    }

    public void mostrarProductos() {
        Iterator<Producto> iterador = productos.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
    
}
