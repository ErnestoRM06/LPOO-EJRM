package practica09;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProcesadorXML {

    public void escribirArchivo(String directorio, String nombre, String enfermedad) {
        try {

            File archivo = new File(directorio);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            try {
                Document doc = builder.parse(archivo);

                Element raiz = doc.getDocumentElement();
                Element pacienteC = doc.createElement("paciente");

                Element nombreC = doc.createElement("nombre");
                nombreC.appendChild(doc.createTextNode(nombre));

                Element enfermedadC = doc.createElement("enfermedad");
                enfermedadC.appendChild(doc.createTextNode(enfermedad));
                
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                Element fecha = doc.createElement("fecha");
                fecha.appendChild(doc.createTextNode(time));
                
                pacienteC.appendChild(nombreC);
                pacienteC.appendChild(enfermedadC);
                pacienteC.appendChild(fecha);

                raiz.appendChild(pacienteC);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(archivo);

                transformer.transform(source, result);
                
            } catch (FileNotFoundException e) {
                Document doc = builder.newDocument();

                Element raiz = doc.createElement("pacientes");
                doc.appendChild(raiz);

                Element pacienteC = doc.createElement("paciente");
                
                Element nombreC = doc.createElement("nombre");
                nombreC.appendChild(doc.createTextNode(nombre));
                pacienteC.appendChild(nombreC);

                Element enfermedadC = doc.createElement("enfermedad");
                enfermedadC.appendChild(doc.createTextNode(enfermedad));
                pacienteC.appendChild(enfermedadC);

                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                Element fecha = doc.createElement("fecha");
                fecha.appendChild(doc.createTextNode(time));
                pacienteC.appendChild(fecha);
                
                raiz.appendChild(pacienteC);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(archivo);

                transformer.transform(source, result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void leerArchivo(String directorio) {
        try {

            File archivo = new File(directorio);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(archivo);

            NodeList listaPacientes = doc.getElementsByTagName("paciente");

            for (int i = 0; i < listaPacientes.getLength(); i++) {

                Node nodo = listaPacientes.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element cliente = (Element) nodo;

                    String nombre = cliente
                            .getElementsByTagName("nombre")
                            .item(0)
                            .getTextContent();

                    String enfermedad = cliente
                            .getElementsByTagName("enfermedad")
                            .item(0)
                            .getTextContent();

                    String fecha = cliente
                            .getElementsByTagName("fecha")
                            .item(0)
                            .getTextContent();

                    System.out.println("\n - Paciente #" + (i + 1));
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Enfermedad por la que ingresó: " + enfermedad);
                    System.out.println("Fecha en la que ingresó: " + fecha);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
