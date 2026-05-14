package practica04;

public class Usuario {
    protected String usuario;
    protected String contraseña;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return "Usuario " + usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void cambiarContraseña(String nuevaContraseña) {
        contraseña = nuevaContraseña;
    }
    
    public void abrirAplicacion() {
        System.out.println("Se ha abierto la aplicación");
    }
    
    public void comprarProducto() {
        System.out.println(this.getUsuario() + " a comprado un producto.");
    }
    
    public void verAcciones() {
        System.out.println("Acciones que el usuario puede realizar:\n - Comprar\n - Cambiar contraseña");
    }
    
}
