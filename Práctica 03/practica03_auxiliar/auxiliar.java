package practica03_auxiliar;

import practica03.Profesor;

public class auxiliar {

    public void comprobarProtect(Profesor profesor) {
        try {
            //Da Error
            System.out.println(profesor.nombre);
        } catch (Exception e) {
            System.out.println("ERROR: el atrivuto es protected y se está llamando fuera de la carpeta.");
        }
        
        System.out.println("Profesor: " + profesor.getNombre());

    }
}
