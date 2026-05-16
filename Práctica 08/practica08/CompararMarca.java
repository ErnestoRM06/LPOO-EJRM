package practica08;

import java.util.Comparator;

public class CompararMarca implements Comparator<Producto> {

    @Override
    public int compare(Producto a, Producto b) {
        return a.getMarca().compareTo(b.getMarca());
    }
}