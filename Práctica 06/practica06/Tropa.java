package practica06;

public class Tropa extends Carta implements Movil, Destruible, Atacante {

    private int daño;
    private int vida = 100;

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida >= 0) {
            this.vida = vida;
        } else {
            System.out.println("ERROR la vida no puede ser menor a 0");
        }
    }

    @Override
    public void mostrarDescripcion() {
        System.out.println("Carta Tropa: " + nombre + "\n - " + descripcion);
    }

    @Override
    public void recibirDaño(int daño) {
        if (vida - daño > 0) {
            vida -= daño;
            System.out.println(nombre + " ha recibido " + daño + " de daño. Vida actual: " + vida);
        } else{
            System.out.println(nombre + " ha muerto.");
            vida = 0;
        }
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " ha caminado a otra dirreción.");
    }

    @Override
    public void hacerDaño(Destruible objetivo) {
        System.out.println(nombre + " ha atacado a un objetivo.");
        
        objetivo.recibirDaño(daño);
    }

}
