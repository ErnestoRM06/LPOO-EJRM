package practica06;

public class Practica06 {

    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        
        Tropa soldado = new Tropa();
        Vehiculo coche = new Vehiculo();
        EdificioDefensivo torre = new EdificioDefensivo();
        
        soldado.setNombre("Soldado común");
        soldado.setDescripcion("Soldado que avanza a pie. Lleva su reifle consigo.");
        soldado.setVida(100);
        soldado.setDaño(70);
        
        coche.setNombre("Carro blindado");
        coche.setDescripcion("Carro utilizado unicamente para transportar tropas.");
        coche.setVida(200);
        
        torre.setNombre("Torre de arqueros");
        torre.setDescripcion("Torre usada para vigilar un punto y defenderlo con habiles arqueros.");
        torre.setVida(500);
        torre.setDaño(100);
        
        mazo.agregarCarta(soldado);
        mazo.agregarCarta(coche);
        mazo.agregarCarta(torre);
        
        mazo.mostrarMazo();
        System.out.println();
        
        mazo.buscarCarta("Soldado común").colocar();
        ( (Movil) mazo.buscarCarta("Soldado común")).moverse();
        ( (Atacante) mazo.buscarCarta("Soldado común")).hacerDaño((Destruible) mazo.buscarCarta("Torre de arqueros"));
        System.out.println();
        
        mazo.buscarCarta("Torre de arqueros").colocar();
        mazo.buscarCarta("Carro blindado").colocar();
        System.out.println();
        
        ( (Atacante) mazo.buscarCarta("Torre de arqueros")).hacerDaño((Destruible) mazo.buscarCarta("Carro blindado"));
        ( (Movil) mazo.buscarCarta("Carro blindado")).moverse();
        ( (Atacante) mazo.buscarCarta("Torre de arqueros")).hacerDaño((Destruible) mazo.buscarCarta("Carro blindado"));
        
        
        
    }
    
}
