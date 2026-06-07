package pia.Modelo;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GeneradorReportes {

    public static void generarReportePDF(String nombreArchivo, int clientesT, int clientesVencidos, float ingresos, int clientesHoy) throws GenerarArchivosException {

        try (PDDocument documento = new PDDocument()) {

            PDPage pagina = new PDPage();
            documento.addPage(pagina);

            PDPageContentStream contenido
                    = new PDPageContentStream(documento, pagina);

            contenido.beginText();

            contenido.setFont(
                    PDType1Font.HELVETICA,
                    12
            );

            contenido.newLineAtOffset(50, 700);

            contenido.showText(
                    "Reporte del dia " + LocalDate.now()
            );

            contenido.newLineAtOffset(0, -30);
            contenido.showText(
                    "Clientes totales: " + clientesT
            );

            contenido.newLineAtOffset(0, -20);
            contenido.showText(
                    "Clientes con membresias vencidas: "
                    + clientesVencidos
            );

            contenido.newLineAtOffset(0, -20);
            contenido.showText(
                    "Ingresos totales: $" + ingresos
            );

            contenido.newLineAtOffset(0, -20);
            contenido.showText(
                    "Clientes que estuvieron en el gimnasio hoy: "
                    + clientesHoy
            );

            contenido.endText();
            contenido.close();

            documento.save(nombreArchivo + ".pdf");

        } catch (IOException e) {
            throw new GenerarArchivosException("No se pudó crear el archivo .pdf");
        }
    }
}
