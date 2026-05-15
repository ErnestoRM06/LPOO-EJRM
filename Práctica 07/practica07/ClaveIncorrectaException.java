package practica07;

public class ClaveIncorrectaException extends ExceptionBase {
    public ClaveIncorrectaException(String mensaje) {
        super("Error, no se encontró la clave ingresada: " + mensaje);
    }
}