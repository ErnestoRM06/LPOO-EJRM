package practica05;

public abstract class Planta {
    protected String nombre;
    protected float altura;
    
    
    public void altura() {
        System.out.println("La planta tiene " + altura + " de altura.");
    }
    
    public void informacion() {
        plantar();
        getNombre();
        getAltura();
    }
    
    public abstract void plantar();
    public abstract String getNombre();
    public abstract float getAltura();

    public String getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
