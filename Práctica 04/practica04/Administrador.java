package practica04;

public class Administrador extends Empleado {
    
    public Administrador(String usuario, String contraseña) {
        super(usuario, contraseña);
    }
    
    @Override
    public String getUsuario() {
        return "Administrador " + usuario;
    }
    
    @Override
    public void abrirAplicacion() {
        System.out.println("Se ha abierto la aplicación como administrador.");
    }
    
    @Override
    public void comprarProducto() {
        System.out.println(this.getUsuario() + " a comprado un producto. Como es administrador se le ha ofrecido un descuento del 25%");
    }
    
    @Override
    public void verAcciones() {
        System.out.println("Acciones que el administrador puede realizar: \n - Comprar\n - Vender\n - Agregar productos\n - Cambiar contraseña");
    }
    
    public void agregarProductos() {
        System.out.println("Se ha agregado un producto al almacen.");
    }
    
}
