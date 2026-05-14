package practica04;

public class Cliente extends Usuario {
    
    public Cliente(String usuario, String contraseña) {
        super(usuario, contraseña);
    }
    
    @Override
    public String getUsuario() {
        return "Cliente " + usuario;
    }
    
    @Override
    public void abrirAplicacion() {
        System.out.println("Se ha abierto la aplicación como cliente.");
    }
    
    @Override
    public void verAcciones() {
        System.out.println("Acciones que el empleado puede realizar: \n - Comprar\n - Cambiar contraseña");
    }
    
}
