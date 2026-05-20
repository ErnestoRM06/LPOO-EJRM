package practica10;

public class Practica10 {

    public static void main(String[] args) {

        BufferCajas buffer = new BufferCajas(4);

        Producto p1 = new Producto("Papel", 20);
        Producto p2 = new Producto("Agua", 15);
        Producto p3 = new Producto("Pollo", 45);
        Producto p4 = new Producto("Tortillas", 28);
        Producto p5 = new Producto("Lapiz", 12);
        Producto p6 = new Producto("Jabon", 63);
        Producto p7 = new Producto("Azucar", 55);
        Producto p8 = new Producto("Cartas", 32);

        Cliente c1 = new Cliente("Ernesto Reyna");
        Cliente c2 = new Cliente("Josué Monrreal");
        Cliente c3 = new Cliente("Julia Idalia");
        Cliente c4 = new Cliente("Jesus Eduardo");
        Cliente c5 = new Cliente("Angel Saul");
        Cliente c6 = new Cliente("Ana Cecilia");
        Cliente c7 = new Cliente("Deyra Pricila");
        Cliente c8 = new Cliente("Eduardo Santos");

        c1.agregarProducto(p1);
        c1.agregarProducto(p2);
        c1.agregarProducto(p8);

        c2.agregarProducto(p3);
        c2.agregarProducto(p4);

        c3.agregarProducto(p6);
        c3.agregarProducto(p2);

        c4.agregarProducto(p2);
        c4.agregarProducto(p4);
        c4.agregarProducto(p7);

        c5.agregarProducto(p5);

        c6.agregarProducto(p5);
        c6.agregarProducto(p6);

        c7.agregarProducto(p1);
        c7.agregarProducto(p8);

        c8.agregarProducto(p3);
        c8.agregarProducto(p5);
        c8.agregarProducto(p7);

        FilaClientes fila = new FilaClientes();
        fila.setBuffer(buffer);
        Caja caja = new Caja();
        caja.setBuffer(buffer);

        fila.agregarCliente(c1);
        fila.agregarCliente(c2);
        fila.agregarCliente(c3);
        fila.agregarCliente(c4);
        fila.agregarCliente(c5);
        fila.agregarCliente(c6);
        fila.agregarCliente(c7);
        fila.agregarCliente(c8);
        fila.agregarCliente(c1);
        fila.agregarCliente(c2);

        Thread filaHilos = new Thread(fila);
        Thread cajaHilos = new Thread(caja);
        filaHilos.start();
        cajaHilos.start();
        try {
            filaHilos.join();
            cajaHilos.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println();
        caja.Mostrar();
    }
}
