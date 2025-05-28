module mx.edu.uacm.is.slt.ds.forki {
    requires javafx.controls;
    requires javafx.fxml;

    opens mx.edu.uacm.is.slt.ds.forki to javafx.fxml;
    opens mx.edu.uacm.is.slt.ds.forki.clases to javafx.base; 

    exports mx.edu.uacm.is.slt.ds.forki;
}
