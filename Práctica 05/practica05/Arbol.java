package practica05;

public class Arbol extends Planta implements Macroscopico {
    private boolean semillas;
    private int frutos;
    
    @Override
    public void plantar() {
        if (semillas) {
            System.out.println("Se plantó la semilla del árbol.");
        } else {
            System.out.println("Se plantó el brote del árbol.");
        }
    }
    
    public void plantar(float altura) {
        System.out.println("Se movió el árbol a un sitio distinto.");
        this.altura = altura;
    }
    
    public void plantar(String arbol) {
        System.out.println("Se implanto una rama del árbol a un " + arbol);
        altura = 0;
    }

    @Override
    public void crecer(float tamaño) {
        System.out.println("El árbol creció " + tamaño + " m.");
        altura += tamaño;
    }
    
    public void crecer() {
        System.out.println("El árbol creció.");
    }
    
    public void crecerFrutos(int cantidad) {
        System.out.println("Al árbol le salieron " + cantidad + " frutos");
        frutos += cantidad;
    }

    @Override
    public String getNombre() {
        return "Árbol " + nombre;
    }

    @Override
    public float getAltura() {
        return altura;
    }

    public boolean isSemillas() {
        return semillas;
    }

    public int getFrutos() {
        return frutos;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSemillas(boolean semillas) {
        this.semillas = semillas;
    }
    
    
    
}
