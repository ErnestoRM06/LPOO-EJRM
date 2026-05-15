package practica07;

public class SaldoInsuficienteException extends ExceptionBase {
    public SaldoInsuficienteException(String mensaje) {
        super("Error, saldo insuficiente en la cuenta: " + mensaje);
    }
}
