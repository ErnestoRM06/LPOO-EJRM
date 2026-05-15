package practica06;

import java.util.ArrayList;

public class Mazo {
    private ArrayList<Carta> coleccion = new ArrayList<>();
    
    public void agregarCarta(Carta nuevo) {
        coleccion.add(nuevo);
    }
    
    public void eliminarCarta(Carta eliminar) {
        coleccion.remove(eliminar);
    }
    
    public void mostrarMazo() {
        coleccion.forEach((carta) -> {
            carta.mostrarDescripcion();
        });
    }
    
    public Carta buscarCarta(String nombre) {
        for (Carta carta : coleccion) {
            if (carta.getNombre().equals(nombre)) {
                return carta;
            }
        }
        return null;
    }
    
}
