package practica03;

import practica03_auxiliar.auxiliar;

public class Practica03 {

    public static void main(String[] args) {
        Alumno alumno1 = new Alumno();
        
        alumno1.setNombre("E23");
        alumno1.setNombre("ERNESTO REYNA");
        
        alumno1.setMatricula(0);
        alumno1.setMatricula(2103944);
        
        alumno1.setCalificacion(112);
        alumno1.setCalificacion(100);
        
        System.out.println(alumno1.getNombre() + ". Matricula: " + alumno1.getMatricula() + ". Calificación: " + alumno1.getCalificacion());
        try {
        //Da Error
        System.out.println(alumno1.nombre);
        } catch (Exception e) {
            System.out.println("ERROR: el atrivuto es private.");
        }
        
        Profesor profesor1 = new Profesor();
        
        profesor1.setNombre("JULIA MONRREAL");
        
        System.out.println("Llamando atrivuto protected con permiso: " + profesor1.nombre);
        
        System.out.print("Llamando sin permiso: ");
        auxiliar aux = new auxiliar();
        aux.comprobarProtect(profesor1);
    }
    
}
