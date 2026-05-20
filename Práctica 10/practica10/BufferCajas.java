package practica10;

import java.util.LinkedList;

public class BufferCajas {

    private LinkedList<Cliente> atendiendo;
    private int cajas;

    public BufferCajas(int cajas) {
        atendiendo = new LinkedList<>();
        this.cajas = cajas;
    }

    public synchronized void agregarCliente(Cliente actual) throws InterruptedException {
        while (atendiendo.size() == cajas) {
            wait();
        }
        atendiendo.add(actual);
        notifyAll();
    }

    public synchronized Cliente cobrar() throws InterruptedException {
        while (atendiendo.isEmpty()) {
            wait();
        }
        Cliente actual = atendiendo.removeFirst();
        actual.calcularTotal();
        
        notifyAll();
        return actual;
    }
} 