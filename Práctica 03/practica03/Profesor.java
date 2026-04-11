package practica03;

public class Profesor {
    protected String nombre;
    protected String telefono;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        if (nombre != null && nombre.matches("[A-ZÑ ]+")) {
            this.nombre = nombre;
        } else {
            System.out.println("ERROR: Por favor escriba el nombre en mayusculas y sin acentos. El nombre no puede contener números ni carácteres especiales.");
        }
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("[0-9]+") && telefono.length() == 10) {
            this.telefono = telefono;
        } else {
            System.out.println("ERROR: Por favor escriba el télefono solo como números. Por favor, no escriba junto al telefono el prefijo regional. El telefono debe contener 10 números.");
        }
    }
}
