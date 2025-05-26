module mx.edu.uacm.is.slt.ds.forki {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base; // No es necesario declararlo explícitamente (lo incluye el compilador por defecto).

    opens mx.edu.uacm.is.slt.ds.forki to javafx.fxml;
    exports mx.edu.uacm.is.slt.ds.forki;
}
