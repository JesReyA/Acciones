module fes.aragon.acciones {
    requires javafx.controls;
    requires javafx.fxml;
    requires Herramientas;
    //requires Herramientas;


    opens fes.aragon.acciones to javafx.fxml;
    exports fes.aragon.acciones;
    exports fes.aragon.acciones.controller;
    opens fes.aragon.acciones.controller to javafx.fxml;
    exports fes.aragon.acciones.inicio;
    opens fes.aragon.acciones.inicio to javafx.fxml;
}