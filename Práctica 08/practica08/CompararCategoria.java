package practica08;

import java.util.Comparator;

public class CompararCategoria implements Comparator<Producto> {

    @Override
    public int compare(Producto a, Producto b) {
        return a.getCategoria().compareToIgnoreCase(b.getCategoria());
    }
}