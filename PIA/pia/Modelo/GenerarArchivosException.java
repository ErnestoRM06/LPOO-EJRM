package pia.Modelo;

public class GenerarArchivosException extends Exception {
    public GenerarArchivosException(String mensaje) {
        super("Error al crear archivo: " + mensaje);
    }
}