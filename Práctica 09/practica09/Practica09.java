package practica09;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Practica09 {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        Archivos gestor = new Archivos();
        Serializador serializador = new Serializador();
        ProcesadorCSV pcsv = new ProcesadorCSV();
        ProcesadorXML pxml = new ProcesadorXML();
        
        String comando;
        String[] partes;

        do {
            System.out.println(">");
            comando = escaner.nextLine();
            partes = comando.split(" ", 2);

            try {
                switch (partes[0]) {
                    case "?":
                        if (partes.length == 1) {
                            System.out.println("\n- Comandos");
                            System.out.println("? //Muestra los comandos existentes");
                            System.out.println("GM -ruta .txt-  -cargo- / -nombre- //Sirve para registrar el medico en un archivo de texto");
                            System.out.println("VM -ruta .txt- //Sirve para ver los médicos en el archivo de texto");
                            System.out.println("GV -ruta .bin-  -vacuna- //Sirve para registrar una vacuna en un archivo binario");
                            System.out.println("VV -ruta .bin- //Sirve para ver vacunas en el archivo binario");
                            System.out.println("GP -ruta .dat-  -paciente- / -telefono- : -tipo de sangre- //Sirve para guardar un paciente como objeto serializado");
                            System.out.println("BP -ruta .dat- //Sirve para buscar paciente como objeto serializado");
                            System.out.println("CCSV -ruta .csv-  - paciente - / - enfermedad - //Sirve para crear archivo CSV con los registros");
                            System.out.println("LCSV -ruta .csv- //Sirve para imprimir en pantalla la información del CSV");
                            System.out.println("CXML -ruta .xml- - paciente - / - enfermedad - //Sirve para crear archivo XML con los registros");
                            System.out.println("LXML -ruta .xml- //Sirve para imprimir en pantalla la información del XML");
                            System.out.println("Backup -ruta- Generar backup del archivo dado");
                            System.out.println("Directorios //Sirve para mostrar la lista con los directorios");
                            System.out.println("exit //Cierra el programa");
                        } else {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        }
                        break;

                    case "GM":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            String[] pGM1 = partes[1].split(" ", 2);
                            if (pGM1.length == 1) {
                                System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                            } else {
                                String[] pGM2 = pGM1[1].split(" / ", 2);
                                if (pGM2.length == 1) {
                                    System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                                } else {
                                    gestor.escribirTexto(pGM1[0], pGM2[0] + " " + pGM2[1]);
                                }
                            }
                        }
                        break;

                    case "VM":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            System.out.println(gestor.leerTexto(partes[1]));
                        }
                        break;

                    case "GV":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            String[] pGV = partes[1].split(" ", 2);
                            if (pGV.length == 1) {
                                System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                            } else {
                                pGV[1] = pGV[1] + " - ";
                                byte[] contenidoB = pGV[1].getBytes(StandardCharsets.UTF_8);
                                gestor.escribirBinario(pGV[0], contenidoB);
                            }
                        }
                        break;

                    case "VV":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            System.out.println(new String(gestor.leerBinario(partes[1]), StandardCharsets.UTF_8));
                        }
                        break;

                    case "GP":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            String[] pGP1 = partes[1].split(" ", 2);
                            if (pGP1.length == 1) {
                                System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                            } else {
                                String[] pGP2 = pGP1[1].split(" / ", 2);
                                if (pGP2.length == 1) {
                                    System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                                } else {
                                    String[] pGP3 = pGP2[1].split(" : ", 2);
                                    if (pGP3.length == 1) {
                                        System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                                    } else {
                                        Paciente agregar = new Paciente(pGP2[0], pGP3[0], pGP3[1]);
                                        serializador.guardarObjeto(agregar, pGP1[0]);
                                    }
                                }
                            }
                        }
                        break;

                    case "BP":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            System.out.println(serializador.cargarObjeto(partes[1]));
                        }
                        break;

                    case "CCSV":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            String[] pCCSV1 = partes[1].split(" ", 2);
                            if (pCCSV1.length == 1) {
                                System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                            } else {
                                String[] pCCSV2 = pCCSV1[1].split(" / ", 2);
                                if (pCCSV2.length == 1) {
                                    System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                                } else {
                                    pcsv.escribirLogCSV(pCCSV1[0], pCCSV2[0], pCCSV2[1]);
                                }
                            }
                        }
                        break;

                    case "LCSV":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            List<String[]> datos = pcsv.leerCSV(partes[1]);
                            datos.forEach(arr -> System.out.println(Arrays.toString(arr)));
                        }
                        break;

                    case "CXML":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            String[] pCXML1 = partes[1].split(" ", 2);
                            if (pCXML1.length == 1) {
                                System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                            } else {
                                String[] pCXML2 = pCXML1[1].split(" / ", 2);
                                if (pCXML2.length == 1) {
                                    System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                                } else {
                                    pxml.escribirArchivo(pCXML1[0], pCXML2[0], pCXML2[1]);
                                }
                            }
                        }
                        break;

                    case "LXML":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            pxml.leerArchivo(partes[1]);
                        }
                        break;

                    case "Backup":
                        if (partes.length == 1) {
                            System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                        } else {
                            gestor.generarBackup(partes[1]);
                        }
                        break;

                    case "Directorios":
                        gestor.listarDirectorio(".");
                        break;

                    case "exit":
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("ERROR: Comando no válido, si quiere saber los comandos válidos ingrese \"?\".");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!comando.equals("exit"));
    }

}
