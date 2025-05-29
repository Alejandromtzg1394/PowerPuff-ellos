package mx.edu.uacm.is.slt.ds.forki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
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
    @FXML
    private Button AgregarTarea;
    
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

        Image imgAgregarTarea = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Mas.png"));
        ImageView vistaAgregarTarea = new ImageView(imgAgregarTarea);
        vistaAgregarTarea.setFitWidth(50);
        vistaAgregarTarea.setFitHeight(50);
        AgregarTarea.setGraphic(vistaAgregarTarea);


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

    @FXML
    private void AgregarTarea() throws IOException {
        // Cargar el FXML de la nueva ventana
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearTareas.fxml"));
        Parent root = loader.load();

        // Configurar el controlador de la nueva ventana
        CrearTareaController controller = loader.getController();
        controller.setInicioController(this.inicioController);

        // Crear la nueva ventana (Stage)
        Stage nuevaVentana = new Stage();
        nuevaVentana.setScene(new Scene(root));
        nuevaVentana.setTitle("Crear Nueva Tarea");

        // Configurar como ventana modal
        Stage ventanaActual = (Stage) AgregarTarea.getScene().getWindow();
        nuevaVentana.initOwner(ventanaActual);
        nuevaVentana.initModality(Modality.WINDOW_MODAL);

        // Mostrar la ventana y esperar hasta que se cierre
        nuevaVentana.showAndWait();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) NombreOperacion.getScene().getWindow();
        stage.close();
    }
}

