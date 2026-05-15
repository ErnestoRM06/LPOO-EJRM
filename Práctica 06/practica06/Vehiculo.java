package practica06;

public class Vehiculo extends Carta implements Movil, Destruible {

    private int vida = 100;

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
        System.out.println("Carta Vehículo: " + nombre + "\n - " + descripcion);
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " se ha movido a otra dirreción.");
    }

    @Override
    public void recibirDaño(int daño) {
        if (vida - daño > 0) {
            vida -= daño;
            System.out.println(nombre + " ha recibido " + daño + " de daño. Vida actual: " + vida);
        } else{
            System.out.println(nombre + " ha sido destruido.");
            vida = 0;
        }
    }
    
}
