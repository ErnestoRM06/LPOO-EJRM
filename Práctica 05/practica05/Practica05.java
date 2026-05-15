package practica05;

import java.util.ArrayList;

public class Practica05 {

    public static void main(String[] args) {
        ArrayList<Planta> lista = new ArrayList<>();
        
        Flor amapola = new Flor();
        Arbol pino = new Arbol();
        Tuberculo papa = new Tuberculo();
        
        amapola.setNombre("Amapola");
        amapola.setColor("Azul");
        
        pino.setNombre("Pino");
        pino.setSemillas(false);
        
        papa.setNombre("Papa");
        
        lista.add(amapola);
        lista.add(pino);
        lista.add(papa);
        
        for(Planta planta : lista) {
            planta.informacion();
            if(planta instanceof Flor) {
                planta = (Flor) planta;
                System.out.println(" - " + planta.getColor());
            }
            
        }
        
    }
    
}
