package mx.edu.uacm.is.slt.ds.forki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import mx.edu.uacm.is.slt.ds.forki.clases.Tarea;

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

       try {
           // El bucle for ahora llamará a AgregarTarea() y añadirá la tarea devuelta.
           ObservableList<Tarea> tareas = FXCollections.observableArrayList();
           for (int i = 0; i < 2; i++) {
               Tarea tareaCreada = mostrarVentanaCrearTarea(); // Llama al nuevo método
               if (tareaCreada != null) {
                   tareas.add(tareaCreada); // Agrega la tarea a la lista de tareas de la operación
                   System.out.printf("Se creo la tarea: %s\n", tareaCreada);
               }
           }
           nuevaOperacion.setTareas(tareas);
           System.out.printf("Tarea Creada: %s\n", nuevaOperacion.getTareas());
       } catch (IOException e) {
           throw new RuntimeException("Error al crear tareas: " + e.getMessage(), e);
       }


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

    // Método modificado para devolver una Tarea
    @FXML // Mantén esta anotación si deseas que el botón "AgregarTarea" también pueda invocarlo directamente
    private Tarea mostrarVentanaCrearTarea() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearTareas.fxml"));
        Parent root = loader.load();

        CrearTareaController controller = loader.getController();
        // Puedes pasar el inicioController si CrearTareaController lo necesita para algo más
        controller.setInicioController(this.inicioController);

        Stage nuevaVentana = new Stage();
        nuevaVentana.setScene(new Scene(root));
        nuevaVentana.setTitle("Crear Nueva Tarea");

        Stage ventanaActual = (Stage) Aceptar.getScene().getWindow();
        nuevaVentana.initOwner(ventanaActual);
        nuevaVentana.initModality(Modality.WINDOW_MODAL);

        // Mostrar la ventana y esperar hasta que se cierre
        nuevaVentana.showAndWait();

        // Después de que la ventana se cierra, recuperamos la tarea creada
        return controller.getTareaCreada();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) NombreOperacion.getScene().getWindow();
        stage.close();
    }
}

