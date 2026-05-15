package practica07;

public class ProductoNoEncontradoException extends ExceptionBase {
    public ProductoNoEncontradoException(String mensaje) {
        super("Error, no se encontró el producto buscado: " + mensaje);
    }
}