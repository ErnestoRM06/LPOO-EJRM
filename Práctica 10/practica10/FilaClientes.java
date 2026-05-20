package practica10;

import java.util.LinkedList;

public class FilaClientes implements Runnable {

    private BufferCajas buffer;
    private final LinkedList<Cliente> fila = new LinkedList<>();

    public void setBuffer(BufferCajas buffer) {
        this.buffer = buffer;
    }

    public void agregarCliente(Cliente agregar) {
        fila.add(agregar);
    }

    @Override
    public void run() {
        for (Cliente pasar : fila) {
            try {
                buffer.agregarCliente(pasar);
                System.out.println("\nSe pasó al cliente " + pasar.getNombre() + " a una caja.");
                Registro log = new Registro("log_caja.csv");
                log.log("Se agregó a cliente " + pasar.getNombre() + " a la fila.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
