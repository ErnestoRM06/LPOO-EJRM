package practica05;

public class Flor extends Planta implements Macroscopico {
    private String color;
    
    @Override
    public void plantar() {
        System.out.println("Se plantó la semilla de la flor.");
        altura = 0;
    }
    
    public void plantar(float altura) {
        System.out.println("Se movió la flor a un sitio distinto.");
        this.altura = altura;
    }
    
    public void plantar(String animal) {
        System.out.println(animal + " plantó la semilla de la flor.");
        altura = 0;
    }

    @Override
    public void crecer(float tamaño) {
        System.out.println("La flor creció " + tamaño + " m.");
        altura += tamaño;
    }
    
    public void crecer() {
        System.out.println("La flor creció.");
    }
    
    public void salir() {
        System.out.println("La flor salió del capullo.");
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getNombre() {
        return "Flor" + nombre;
    }

    @Override
    public float getAltura() {
        return altura;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
