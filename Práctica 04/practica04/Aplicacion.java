package practica04;

import java.util.ArrayList;

public class Aplicacion {
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    public void agregarUsuario(int opcion, String usuario, String contraseña) {
        Usuario nuevo = new Usuario(usuario, contraseña);
        
        switch(opcion) {
            case 1: 
                nuevo = new Cliente(usuario, contraseña);
                break;
            case 2: 
                nuevo = new Empleado(usuario, contraseña);
                break;    
            case 3: 
                nuevo = new Administrador(usuario, contraseña);
                break;    
        }
        
        listaUsuarios.add(nuevo);
    }
    
    public void mostrarUsuarios(){
        listaUsuarios.forEach((usuario) -> {
            System.out.println(" - " + usuario.getUsuario());
        });
    }
    
    public Usuario buscarUsuario(String buscar) {
        for(Usuario usuario : listaUsuarios) {
            if(usuario.usuario.equals(buscar))
                return usuario;
        }
        return null;
    }
    
    public void compra (Usuario comprador, Empleado vendedor) {
        comprador.comprarProducto();
        vendedor.venderProducto(comprador);
    }
    
    
}
