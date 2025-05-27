package mx.edu.uacm.is.slt.ds.forki;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.forki.clases.Operacion;

public class CrearOperacionController implements Initializable  {

    @FXML
    private TextField NombreOperacion;
    @FXML
    private TextField Precondicion;
    @FXML
    private TextField Postcondicion;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;
    
    private InicioController inicioController;
    
    public void setInicioController(InicioController controller) {
        this.inicioController = controller;
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


    } catch (Exception e) {
        System.out.println("Error al cargar la imagen: " + e.getMessage());
    }
}

   @FXML
private void Aceptar() {
    Operacion nuevaOperacion = new Operacion();
    nuevaOperacion.setNombre(NombreOperacion.getText());
    nuevaOperacion.setPrecondiciones(Precondicion.getText());
    nuevaOperacion.setPostcondiciones(Postcondicion.getText());
    nuevaOperacion.setId_operacion((int) (Math.random() * 1000));
    nuevaOperacion.setEstado("Detenido");

    if (inicioController != null) {
        javafx.application.Platform.runLater(() -> {
            inicioController.agregarOperacion(nuevaOperacion);
        });
    }

    cerrarVentana();
}


    @FXML
    private void Cancelar() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) NombreOperacion.getScene().getWindow();
        stage.close();
    }
}

  