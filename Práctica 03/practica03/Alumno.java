package practica03;

public class Alumno {
    private String nombre;
    private float calificacion;
    private int matricula;

    public String getNombre() {
        return nombre;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNombre(String nombre) {
        if (nombre != null && nombre.matches("[A-ZÑ ]+")) {
            this.nombre = nombre;
        } else {
            System.out.println("ERROR: Por favor escriba el nombre en mayusculas y sin acentos. El nombre no puede contener números ni carácteres especiales.");
        }
        
    }

    public void setCalificacion(float calificacion) {
        if (calificacion >= 0 && calificacion <= 100) {
            this.calificacion = calificacion;
        } else {
            System.out.println("ERROR: La calificación no puede ser mayor a 100, ni menor a 0.");
        }
    }

    public void setMatricula(int matricula) {
        if (matricula > 0) {
            this.matricula = matricula;
        } else {
            System.out.println("ERROR: La matricula no puede ser igual a 0 ni menor.");
        }
    }

    
    
}
