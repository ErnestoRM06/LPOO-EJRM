package practica11;

public class CRUDCliente {
    static int cantidad = 1;
    private String nombre;
    private String fecha;
    private String total;
    private int id;

    public CRUDCliente(String nombre, String fecha, String total) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.total = total;
        this.id = cantidad++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
