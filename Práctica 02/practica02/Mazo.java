package practica02;

public class Mazo {
    float dinero;
    Cartas[] cartas = new Cartas[0];

    public Mazo() {
        dinero = 1000;
    }
    
    void agregarDinero(float agregar) {
        dinero += agregar;
    }
    
    void agregarCarta(String nombre, String descripcion, int vida, int daño, float coste) {
        Cartas agregar;
        if (vida > 0) {
            agregar = new Cartas(nombre, descripcion, coste, daño, vida);
        } else {
            if (daño > 0) {
                agregar = new Cartas(nombre, descripcion, coste, daño);
            } else {
                agregar = new Cartas(nombre, descripcion, coste);
            }
        }
        
        Cartas[] nuevo = new Cartas[cartas.length + 1];
        
        System.arraycopy(cartas, 0, nuevo, 0, cartas.length);
        nuevo[cartas.length] = agregar;
        
        cartas = nuevo;
    }
    
    void subirNivel(Cartas carta) {
        if(dinero - carta.coste >= 0) {
            carta.subirNivel();
            dinero -= carta.coste;
        } else {
            System.out.println("ERROR: Dinero insuficiente");
        }
    }
    
    void reiniciarNivel(Cartas carta) {
        dinero += carta.reiniciarNivel();
    }
    
    Cartas buscarCarta(String buscar) {
        for(Cartas carta : cartas) {
            if (carta.nombre.equals(buscar)) {
                return carta;
            }
        }
        return null;
    }
    
    void mostrarCartas() {
        System.out.println("\nCartas en el mazo:");
        for(Cartas carta : cartas) {
            carta.mostrarInformación();
        }
    }
    
}
