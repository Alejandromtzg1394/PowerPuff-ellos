/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.forki;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.forki.clases.Tarea;

/**
 *
 * @author Alejandro
 */
public class EditarTareasController implements Initializable {

    @FXML
    private MenuBar MenuHome;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;
    @FXML
    private Button Eliminar;
    @FXML
    private TextField NombreTarea;
    @FXML
    private TextField Precondicion;
    @FXML
    private TextField Postcondicion;
    @FXML
    private TextArea Instrucciones;
    @FXML
    private ComboBox<String> comboEstado;
    
    private Tarea tarea;
    
    private TableView<Tarea> tablaTareas;
    
     @Override
public void initialize(URL url, ResourceBundle rb) {
    try {
        
        ObservableList<String> estados = FXCollections.observableArrayList(
                "detenida","ejecucion","pausa"
        );
        comboEstado.setItems(estados);
       
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

        Image imgElimina = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Elimina.png"));
        ImageView vistaElimina = new ImageView(imgElimina);
        vistaElimina.setFitWidth(50);
        vistaElimina.setFitHeight(50);
        Eliminar.setGraphic(vistaElimina);

    } catch (Exception e) {
        System.out.println("Error al cargar la imagen: " + e.getMessage());
    }
}    

    public void setTarea(Tarea tarea){
        this.tarea = tarea;
        cargarDatosTarea();
    }
    
    private void cargarDatosTarea(){
        if(tarea != null){
            NombreTarea.setText(tarea.getNombre());
            Precondicion.setText(tarea.getPrecondiciones());
            Postcondicion.setText(tarea.getPostcondiciones());
            Instrucciones.setText(tarea.getInstrucciones());
            
            if (tarea.getEstado() != null && !tarea.getEstado().isEmpty()) {
                comboEstado.setValue(tarea.getEstado());
            } else {
                comboEstado.getSelectionModel().selectFirst(); // O selecciona un valor por defecto si el estado es nulo/vacío
            }
        }
    }
    
    public void setTablaTareas(TableView<Tarea> tablaTareas){
        this.tablaTareas = tablaTareas;
    }

    @FXML
    private void Aceptar(ActionEvent event) {
        if(tarea != null){
            tarea.setNombre(NombreTarea.getText());
            tarea.setPrecondiciones(Precondicion.getText());
            tarea.setPostcondiciones(Postcondicion.getText());
            tarea.setInstrucciones(Instrucciones.getText());
            tarea.setEstado(comboEstado.getValue());
            
            if(tablaTareas != null){
                tablaTareas.refresh();
            }
            
            cerrarVentana();
        }
       
        
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        tablaTareas.getItems().remove(tarea);
    }
    
    private void cerrarVentana(){
        Stage stage = (Stage) Cancelar.getScene().getWindow();
        stage.close();
    }
    
}
