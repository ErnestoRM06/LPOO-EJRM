package practica08;

import java.util.Scanner;

public class Practica08 {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner escaner = new Scanner(System.in);
        
        long inicio, fin;

        Producto p1 = new Producto("Nestle", "Nutella", (float) 35.9, "Comida");
        Producto p2 = new Producto("Fruteria", "Platano", (float) 12, "Comida");
        Producto p3 = new Producto("Coca Cola", "Coca cola 2L", (float) 50, "Bebida");
        Producto p4 = new Producto("BIC", "Pluma azul", (float) 15, "Utiles");
        Producto p5 = new Producto("Nestle", "Harina", (float) 42, "Comida");
        Producto p6 = new Producto("Fruteria", "Manzana", (float) 8.9, "Comida");
        Producto p7 = new Producto("Colgate", "Pasta de dientes", (float) 32, "Salud");
        Producto p8 = new Producto("Dove", "Jabon de Barra", (float) 41, "Salud");
        Producto p9 = new Producto("AXE", "Deshodorante", (float) 32, "Salud");
        Producto p10 = new Producto("Del Valle", "Jugo de naranja", (float) 22, "Bebida");
        Producto p11 = new Producto("Del Valle", "Barra nutritiva", (float) 14, "Comida");
        Producto p12 = new Producto("Limpiadores", "Jabon de Barra", (float) 36, "Salud");
        Producto p13 = new Producto("Limpiadores", "Cloro", (float) 56, "Limpieza");
        Producto p14 = new Producto("BIC", "Libreta", (float) 25, "Papeleria");
        Producto p15 = new Producto("Limpiadores", "Tijeras", (float) 17.5, "Utiles");
        
        Cliente c1 = new Cliente("Ernesto");
        Cliente c2 = new Cliente("Josué");
        Cliente c3 = new Cliente("Reyna");
        Cliente c4 = new Cliente("Monrreal");
        Cliente c5 = new Cliente("Eduardo");
        Cliente c6 = new Cliente("Julia");
        
        tienda.agregarProducto(p1);
        tienda.agregarProducto(p2);
        tienda.agregarProducto(p3);
        tienda.agregarProducto(p4);
        tienda.agregarProducto(p5);
        tienda.agregarProducto(p6);
        tienda.agregarProducto(p7);
        tienda.agregarProducto(p8);
        tienda.agregarProducto(p9);
        tienda.agregarProducto(p10);
        tienda.agregarProducto(p11);
        tienda.agregarProducto(p12);
        tienda.agregarProducto(p13);
        tienda.agregarProducto(p14);
        tienda.agregarProducto(p15);
        
        tienda.agregarCliente(c1);
        tienda.agregarCliente(c2);
        tienda.agregarCliente(c3);
        tienda.agregarCliente(c4);
        tienda.agregarCliente(c5);
        tienda.agregarCliente(c6);

        int opcion;
        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Agregar cliente a la fila");
            System.out.println("5. Agregar producto a cliente en la cabeza");
            System.out.println("6. Cobrar a cliente");
            System.out.println("7. Mostrar marcas");
            System.out.println("8. Buscar productos por marcas");
            System.out.println("9. Buscar productos por marca y precio");
            System.out.println("10. Agregar empleado");
            System.out.println("11. Buscar clave de empleado");
            System.out.println("0. Salir");
            opcion = escaner.nextInt();
            escaner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = escaner.nextLine();
                    System.out.print("Marca: ");
                    String marca = escaner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = escaner.nextLine();
                    System.out.print("Precio: ");
                    float precio = (float) escaner.nextDouble();
                    escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    tienda.agregarProducto(new Producto(marca, nombre, precio, categoria));
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en agregar el producto: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 2:
                    System.out.print("Producto a buscar: ");
                    String buscar = escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    System.out.println(tienda.buscarProducto(buscar));
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en buscar el producto: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 3:
                    inicio = System.nanoTime();
                    tienda.mostrarProductos();
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en mostrar todos los productos disponibles: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 4:
                    System.out.print("Nombre del cliente que se va a agregar a la fila: ");
                    String cliente = escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    tienda.agregarCliente(new Cliente(cliente));
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en agregar al cliente a la fila: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 5:
                    System.out.print("Nombre del producto que se va a agregar al cargo del cliente: ");
                    String producto = escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    Producto agregar = tienda.buscarProducto(producto);
                    if (agregar != null) {
                        tienda.agregarProductoACliente(agregar);
                    } else {
                        System.out.println("No se encontró el producto");
                    }
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en agregar el producto a la cuenta del cliente: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 6:
                    inicio = System.nanoTime();
                    System.out.println("Se le cobró al cliente: ");
                    tienda.cobrarCliente();
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en cobrar al cliente: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 7:
                    inicio = System.nanoTime();
                    tienda.mostrarMarcas();
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en mostrar todas las marcas: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 8:
                    System.out.print("Marca a buscar: ");
                    String marcaBuscar = escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    System.out.println(tienda.buscarPorMarca(marcaBuscar));
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en buscar todos los productos de una marca y mostrarlos: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 9:
                    System.out.print("Marca a buscar: ");
                    String marcaB = escaner.nextLine();
                    System.out.print("Precio al que se buca que sea menor: ");
                    float precioBuscar = (float) escaner.nextDouble();
                    escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    System.out.println(tienda.buscarPorMarcaYPrecio(marcaB, precioBuscar));
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en buscar todos los productos de una marca y menores a un precio y mostrarlos: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 10:
                    System.out.print("Nombre: ");
                    String empleado = escaner.nextLine();
                    System.out.print("Clave: ");
                    String clave = escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    tienda.registrarEmpleado(empleado, clave);
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en registrar al empleado: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 11:
                    System.out.print("Empleado a buscar su clave: ");
                    String buscarEmpleado = escaner.nextLine();
                    
                    inicio = System.nanoTime();
                    System.out.println(tienda.obtenerClave(buscarEmpleado));
                    fin = System.nanoTime();
                    System.out.println("\n - Tiempo que el sistema tardo en buscar la clave del empleado: " + (fin - inicio) + " ns\n");
                    
                    break;
                    
                case 0:
                    
                    break;
                default:
                    System.out.println("ERROR: Opción no válida");
            }
        } while (opcion != 0);
    }
}
