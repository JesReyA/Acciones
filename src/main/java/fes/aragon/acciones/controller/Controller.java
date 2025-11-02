package fes.aragon.acciones.controller;

import fes.aragon.acciones.inicio.GananciaPerdida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Controller {
    FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("CSV", "*.csv");
    GananciaPerdida reporteAcciones = new GananciaPerdida();
    File selectedFile;
    @FXML
    private Button buttonObtenerReporte;

    @FXML
    public void handleElegirArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fileChooser.getExtensionFilters().addAll(ex1);
        selectedFile = fileChooser.showOpenDialog(stage);
        if(selectedFile != null){
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Se eligió el archivo con éxito\n Presiona \"Obtener Reporte\" para generarlo");
            buttonObtenerReporte.setDisable(false);
        }
    }

    @FXML
    public void handleObtenerReporte(ActionEvent event) {
        reporteAcciones.obtenerReporte(selectedFile.getAbsolutePath());

        File archivoReporte = new File("Reporte.txt");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Reporte");
        fileChooser.setInitialFileName("ReporteAcciones.txt");

        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("TXT", "*.txt");
        fileChooser.getExtensionFilters().add(ext2);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File archivoDestino = fileChooser.showSaveDialog(stage);

        if(archivoDestino != null){
            try{
                Files.copy(archivoReporte.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                mostrarAlerta(Alert.AlertType.INFORMATION, "ÉXITO", "Reporte guardado con éxito en: \n" + archivoDestino.getAbsolutePath());
            } catch (IOException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error al Guardar", "No se pudo copiar el archivo: " + e.getMessage());
            }
        }
        archivoReporte.delete();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
