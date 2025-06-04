package mx.edu.uacm.is.slt.ds.forki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.forki.clases.Operacion;
import mx.edu.uacm.is.slt.ds.forki.clases.Tarea;

public class EditarOperacionesController implements Initializable {

    @FXML
    private TableView<Tarea> TabTareas;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;
    @FXML
    private Button Ordenar;
    @FXML
    private Button Eliminar;
    @FXML
    private Button EditarTarea;
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
            
            Image imgEdita = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Editar.png"));
            ImageView vistaEdita = new ImageView(imgEdita);
            vistaEdita.setFitWidth(50);
            vistaEdita.setFitHeight(50);
            EditarTarea.setGraphic(vistaEdita);

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
        
        TabTareas.setItems(operacion.getTareas());
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
    
    
    @FXML
    private void EditarTarea(ActionEvent event) throws IOException {
        Tarea tareaSeleccionada = TabTareas.getSelectionModel().getSelectedItem();
        if(tareaSeleccionada == null ) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Requerimiento");
            alerta.setHeaderText("Ninguna tarea seleccionada a editar");
            alerta.setContentText("Debes seleccionar una tarea para editar.");
            alerta.showAndWait();
            return;
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarTareas.fxml"));
        Parent root = loader.load();
        
        EditarTareasController controller = loader.getController();
        controller.setTarea(tareaSeleccionada);
        controller.setTablaTareas(TabTareas);
        
        Stage ventana = new Stage();
        ventana.setScene(new Scene(root));
        ventana.setTitle("Editar Tarea");
        ventana.initModality(Modality.WINDOW_MODAL);
        ventana.initOwner(((Node) event.getSource()).getScene().getWindow());
        ventana.showAndWait();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) Cancelar.getScene().getWindow();
        stage.close();
    }

}
