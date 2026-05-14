package practica04;

public class Practica04 {

    public static void main(String[] args) {
        Aplicacion app = new Aplicacion();
        
        app.agregarUsuario(3, "EJRM", "2103944");
        app.agregarUsuario(2, "Ernesto", "123");
        app.agregarUsuario(1, "Josué", "abc");
        app.agregarUsuario(0, "Reyna", "contraseña");
        
        app.mostrarUsuarios();
        
        app.buscarUsuario("EJRM").abrirAplicacion();
        app.buscarUsuario("Ernesto").abrirAplicacion();
        app.buscarUsuario("Josué").abrirAplicacion();
        app.buscarUsuario("Reyna").abrirAplicacion();
        
        app.compra(app.buscarUsuario("EJRM"), (Empleado) app.buscarUsuario("Ernesto"));
        app.compra(app.buscarUsuario("Ernesto"), (Empleado) app.buscarUsuario("EJRM"));
        app.compra(app.buscarUsuario("Josué"), (Empleado) app.buscarUsuario("Ernesto"));
        app.compra(app.buscarUsuario("Reyna"), (Empleado) app.buscarUsuario("EJRM"));
        
    }
    
}
