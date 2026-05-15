package practica07;

public class Practica07 {

    public static void main(String[] args) {
        Tienda soriana = new Tienda();
        Tarjeta tarjetaEJRM = new Tarjeta("123", 1000);
        Producto camisa = new Producto("Camisa azul", 600);
        Producto computador = new Producto("Computador de escritorio", 1200);
        
        soriana.agregarTarjeta(tarjetaEJRM);
        soriana.agregarProducto(camisa);
        soriana.agregarProducto(computador);
        
        soriana.mostrarProductos();
        System.out.println();
        
        //Error de producto
        soriana.procesarOperacion("Camisa", "123");
        
        //Error de clave
        soriana.procesarOperacion("Camisa azul", "abc");
        
        //Error de que se pase el precio del sueldo
        soriana.procesarOperacion("Computador de escritorio", "123");
        System.out.println();
        
        //Operación exitosa
        soriana.procesarOperacion("Camisa azul", "123");
        
    }
    
}
