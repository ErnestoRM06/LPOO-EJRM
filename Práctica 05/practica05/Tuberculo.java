package practica05;

public class Tuberculo extends Planta implements Macroscopico {
    
    private float peso;
    
    @Override
    public void plantar() {
        System.out.println("Se plantó un ejemplar del tuberculo.");
        altura = 0;
        peso = 0;
    }
    
    public void plantar(float altura) {
        System.out.println("Se movio una plantación ya establecida");
        this.altura = altura;
    }

    @Override
    public void crecer(float tamaño) {
        System.out.println("La plantación creció " + tamaño + " m.");
        altura += tamaño;
    }
    
    public void crecer(float tamaño, float peso) {
        System.out.println("La plantación creció " + tamaño + " m. Se comprobó su peso y cambió a " + peso + " kg");
        altura += tamaño;
        this.peso += peso;
    }
    
    public void crecer(int ejemplares) {
        System.out.println("A la plantación le salieron " + ejemplares + " ejemplares.");
    }

    @Override
    public String getNombre() {
        return "Tuberculo " + nombre;
    }

    @Override
    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
