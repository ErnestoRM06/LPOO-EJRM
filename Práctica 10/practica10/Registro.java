package practica10;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Registro {
    private String archivo;

    public Registro(String archivo) {
        this.archivo = archivo;
    }

    public synchronized void log(String mensaje) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(LocalDateTime.now() + "," + mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
