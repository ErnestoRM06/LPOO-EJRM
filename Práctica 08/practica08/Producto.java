package practica08;

public class Producto implements Comparable<Producto> {
    
    private String marca;
    private String nombre;
    private float precio;
    private String categoria;

    public Producto(String marca, String nombre, float precio, String categoria) {
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public int compareTo(Producto o) {
        return this.nombre.compareTo(o.nombre);
    }
    
    @Override
    public String toString() {
        return "Producto " + nombre + ". Categoria: " +  categoria + ", Marca: " +  marca + ". $" + precio;
    }
    
    
    
}
