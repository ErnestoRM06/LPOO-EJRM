package practica02;

public class practica02 {
    
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        
        mazo.agregarCarta("Rayo", "Un hechizo que ataca al enemigo de más vida", 0, 200, 100);
        mazo.agregarCarta("Soldado", "Una unidad que ataca con un rifle", 120, 100, 75);
        mazo.agregarCarta("Tanque", "Un unidad de mucha potencia", 200, 100, 150);
        mazo.agregarCarta("Roba cartas", "Al usar esta carta obtienes tres cartas", 0, 0, 50);
        mazo.agregarCarta("Bomba", "Un hechizo que ataca a todos los enemigos", 0, 50, 90);
        
        mazo.mostrarCartas();
        
        mazo.subirNivel(mazo.buscarCarta("Tanque"));
        mazo.subirNivel(mazo.buscarCarta("Tanque"));
        mazo.subirNivel(mazo.buscarCarta("Bomba"));
        mazo.mostrarCartas();
        
        System.out.println("");
        mazo.buscarCarta("Bomba").cambiarDañoBase(60);
        mazo.buscarCarta("Bomba").mostrarInformación();
        
        System.out.println("");
        mazo.buscarCarta("Soldado").cambiarVidaBase(150);
        mazo.buscarCarta("Soldado").mostrarInformación();
        
        System.out.println("");
        mazo.buscarCarta("Roba cartas").cambiarCoste(75);
        mazo.buscarCarta("Roba cartas").mostrarInformación();
        
        mazo.reiniciarNivel(mazo.buscarCarta("Tanque"));
        
        mazo.mostrarCartas();
    }
}
