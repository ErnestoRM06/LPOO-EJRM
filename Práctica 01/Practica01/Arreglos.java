//Elemento de desición propia

package Practica01;

import java.util.ArrayList;

public class Arreglos {

    public static void main(String[] args) {
        
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("Hola");
        lista.add("mundo");
        lista.add("Hola");
        lista.add("EJRM");
        
        System.out.println(lista);
        System.out.println("En la primera posición está: " + lista.get(0));
        System.out.println("\"EJRM\" está en la posición: " + (lista.indexOf("EJRM") + 1));
        
        lista.remove(3);
        lista.remove("Hola");
        System.out.println(lista);
    }
}
