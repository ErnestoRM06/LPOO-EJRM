package practica07;

public class Tarjeta {
    private String clave;
    private float saldo;

    public Tarjeta(String clave, float saldo) {
        this.clave = clave;
        this.saldo = saldo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
