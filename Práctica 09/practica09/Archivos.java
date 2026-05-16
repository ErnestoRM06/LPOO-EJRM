package practica09;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Archivos {

    public void escribirTexto(String ruta, String contenido) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(contenido);
        }
    }

    public String leerTexto(String ruta) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        }
        return sb.toString();
    }

    public void escribirBinario(String ruta, byte[] datos) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(ruta)) {
            fos.write(datos);
        }
    }

    public byte[] leerBinario(String ruta) throws IOException {
        return Files.readAllBytes(Paths.get(ruta));
    }

    public void crearDirectorio(String ruta) throws IOException {
        Files.createDirectories(Paths.get(ruta));
    }

    public void listarDirectorio(String ruta) throws IOException {
        Files.list(Paths.get(ruta)).forEach(System.out::println);
    }

    public void eliminarArchivo(String ruta) throws IOException {
        Files.deleteIfExists(Paths.get(ruta));
    }

    public void moverArchivo(String origen, String destino) throws IOException {
        Files.move(Paths.get(origen), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
    }

    public void generarBackup(String archivoOriginal) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String[] partes = archivoOriginal.split(".");
        
        String backup = partes[0] + "_backup_" + timestamp + ".dat";
        Files.copy(Paths.get(archivoOriginal), Paths.get(backup), StandardCopyOption.REPLACE_EXISTING);
    }

}
