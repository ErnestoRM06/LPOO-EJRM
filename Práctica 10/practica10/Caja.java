package practica10;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Caja extends Thread {

    private ArrayList<Cliente> clientesCobrados;
    private float dineroCobrado;
    private BufferCajas buffer;

    public Caja() {
        clientesCobrados = new ArrayList();
        dineroCobrado = 0;
    }

    public void setBuffer(BufferCajas buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Cliente actual = buffer.cobrar();
                clientesCobrados.add(actual);
                dineroCobrado += actual.getTotal();

                System.out.println("\nSe cobró a un cliente: " + actual);
                Registro log = new Registro("log_caja.csv");
                log.log("Se cobró a un cliente: " + actual);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Mostrar() {
        System.out.println("Clientes a los que se le cobró en la caja: ");
        for (Cliente cliente : clientesCobrados) {
            System.out.println(cliente);
        }
        System.out.println(" - Total: $" + dineroCobrado);
    }

}
