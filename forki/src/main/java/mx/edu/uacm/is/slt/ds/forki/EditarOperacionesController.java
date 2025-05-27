package mx.edu.uacm.is.slt.ds.forki;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.forki.clases.Operacion;

public class EditarOperacionesController implements Initializable {

    @FXML
    private TableView<?> TabTareas;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;
    @FXML
    private Button Ordenar;
    @FXML
    private Button Eliminar;
    @FXML
    private TextField NombreOperacion;
    @FXML
    private TextField Precondicion;
    @FXML
    private TextField Postcondicion;
    @FXML
    private TableColumn<?, ?> NomTareas;

    private Operacion operacion;
    
    private TableView<Operacion> tablaOperaciones;

public void setTablaOperaciones(TableView<Operacion> tablaOperaciones) {
    this.tablaOperaciones = tablaOperaciones;
}


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Image imgAceptar = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Aceptar.png"));
            ImageView vistaAceptar = new ImageView(imgAceptar);
            vistaAceptar.setFitWidth(50);
            vistaAceptar.setFitHeight(50);
            Aceptar.setGraphic(vistaAceptar);

            Image imgCancelar = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Cancelar.png"));
            ImageView vistaCancelar = new ImageView(imgCancelar);
            vistaCancelar.setFitWidth(50);
            vistaCancelar.setFitHeight(50);
            Cancelar.setGraphic(vistaCancelar);

            Image imgOrden = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Orden.png"));
            ImageView vistaOrden = new ImageView(imgOrden);
            vistaOrden.setFitWidth(50);
            vistaOrden.setFitHeight(50);
            Ordenar.setGraphic(vistaOrden);

            Image imgElimina = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Elimina.png"));
            ImageView vistaElimina = new ImageView(imgElimina);
            vistaElimina.setFitWidth(50);
            vistaElimina.setFitHeight(50);
            Eliminar.setGraphic(vistaElimina);

        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }    

  
    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
        cargarDatosOperacion();
    }

  
    private void cargarDatosOperacion() {
    if (operacion != null) {
        NombreOperacion.setText(operacion.getNombre());
        Precondicion.setText(operacion.getPrecondiciones());      
        Postcondicion.setText(operacion.getPostcondiciones());    
    }
}

    @FXML
private void Aceptar(ActionEvent event) {
    if (operacion != null) {
        operacion.setNombre(NombreOperacion.getText());
        operacion.setPrecondiciones(Precondicion.getText());      
        operacion.setPostcondiciones(Postcondicion.getText());

        // Refrescar la tabla original
        if (tablaOperaciones != null) {
            tablaOperaciones.refresh();
        }

        cerrarVentana();
    }
}
 
    @FXML
    private void Cancelar(ActionEvent event) {
        
        cerrarVentana();
    }

    @FXML
    private void Ordenar(ActionEvent event) {
        
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        
    }

    private void cerrarVentana() {
        Stage stage = (Stage) Cancelar.getScene().getWindow();
        stage.close();
    }

}
