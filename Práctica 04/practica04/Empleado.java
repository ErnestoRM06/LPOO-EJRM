package practica04;

public class Empleado extends Usuario{
    public Empleado(String usuario, String contraseña) {
        super(usuario, contraseña);
    }
    
    @Override
    public String getUsuario() {
        return "Empleado " + usuario;
    }
    
    @Override
    public void abrirAplicacion() {
        System.out.println("Se ha abierto la aplicación como empleado.");
    }
    
    @Override
    public void comprarProducto() {
        System.out.println(this.getUsuario() + " a comprado un producto. Como es empleado se le ha ofrecido un descuento del 15%");
    }
    
    public void venderProducto(Usuario comprador) {
        System.out.println(this.getUsuario() + " ha vendido un producto a " + comprador.getUsuario());
    }
    
    @Override
    public void verAcciones() {
        System.out.println("Acciones que el empleado puede realizar: \n - Comprar\n - Vender\n - Cambiar contraseña");
    }
    
}
