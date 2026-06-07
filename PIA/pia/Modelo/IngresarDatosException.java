package pia.Modelo;

public class IngresarDatosException extends Exception {
    public IngresarDatosException(String mensaje) {
        super("Error al ingresar datos: " + mensaje);
    }
}
