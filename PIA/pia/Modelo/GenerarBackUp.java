package pia.Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class GenerarBackUp extends Thread {

    private BackUp guardar;
    private String ruta;

    public GenerarBackUp(String ruta) {
        guardar = new BackUp(Nexo.gimnasio.oClientes, Nexo.gimnasio.oClases, Nexo.gimnasio.oEquipo, Nexo.gimnasio.oAsistencia, Nexo.gimnasio.total);
        this.ruta = ruta + ".dat";
    }

    @Override
    public void run() {
        try {
            guardarObjeto();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Exito en guardar backup.");
            alerta.setTitle("Aviso!");
            alerta.setContentText("Se creo el archivo " + ruta + ".dat");
            alerta.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(GenerarBackUp.class.getName()).log(Level.SEVERE, null, ex);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Error al generar backup");
            alerta.setTitle("Advertencia!");
            alerta.setContentText("No se pudó generar el backup");
            alerta.showAndWait();
        }

    }

    public void guardarObjeto() throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(guardar);
        }
    }

    public BackUp cargarObjeto() throws GenerarArchivosException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (BackUp) ois.readObject();
        } catch (Exception ex) {
            throw new GenerarArchivosException("No se pudó abrir el archivo .dat. Pruebe con otra ruta.");
        }
    }
}
