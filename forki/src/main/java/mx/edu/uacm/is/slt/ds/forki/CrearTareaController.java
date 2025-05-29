package mx.edu.uacm.is.slt.ds.forki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    private InicioController inicioController;
    
    
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


    } catch (Exception e) {
        System.out.println("Error al cargar la imagen: " + e.getMessage());
    }
}

    public void setInicioController(InicioController inicioController) {
        this.inicioController = inicioController;
    }

    @FXML
    private void Aceptar(ActionEvent event) {
    }

    @FXML
    private void Cancelar(ActionEvent event) {
    }
}