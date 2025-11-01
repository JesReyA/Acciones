package fes.aragon.acciones.controller;

import fes.aragon.acciones.inicio.GananciaPerdida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("CSV", "*.csv");
    GananciaPerdida reporteAcciones = new GananciaPerdida();
    File selectedFile;
    @FXML
    private Button buttonElegirArchivo, buttonObtenerReporte;

    @FXML
    public void handleElegirArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fileChooser.getExtensionFilters().addAll(ex1);
        selectedFile = fileChooser.showOpenDialog(stage);
    }

    @FXML
    public void handleObtenerReporte(ActionEvent event) {
        reporteAcciones.obtenerReporte(selectedFile.getAbsolutePath());
    }
}
