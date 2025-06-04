package mx.edu.uacm.is.slt.ds.forki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.forki.clases.Tarea;

public class CrearTareaController implements Initializable  {

    @FXML
    private TextField NombreTarea;
    @FXML
    private TextField Precondicion;
    @FXML
    private TextField Postcondicion;
    @FXML
    private ComboBox<String> Estado;
    @FXML
    private TextArea Instrucciones;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;

    private Tarea tareaCreada;

    private InicioController inicioController;
    
    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    public Tarea getTareaCreada() {
        return tareaCreada;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        ObservableList<String> estados = FXCollections.observableArrayList(
                "Detenida","Ejecución","Pausa"
        );
        Estado.setItems(estados);
       
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


    } catch (Exception e) {
        System.out.println("Error al cargar la imagen: " + e.getMessage());
    }
}

   

    @FXML
    private void Aceptar(ActionEvent event) {
    Tarea nuevaTarea = new Tarea();
    nuevaTarea.setEstado(Estado.getValue());
    nuevaTarea.setNombre(NombreTarea.getText());
    nuevaTarea.setInstrucciones(Instrucciones.getText());
    nuevaTarea.setPrecondiciones(Precondicion.getText());
    nuevaTarea.setPostcondiciones(Postcondicion.getText());
    nuevaTarea.setId_tarea((int)(Math.random() * 1000));


    cerrarVentana();
}

    @FXML
    private void Cancelar(ActionEvent event) {
         cerrarVentana();
    }
    
    private void cerrarVentana() {
        Stage stage = (Stage) NombreTarea.getScene().getWindow();
        stage.close();
    }
}