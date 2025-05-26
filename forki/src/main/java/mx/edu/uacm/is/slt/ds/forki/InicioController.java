package mx.edu.uacm.is.slt.ds.forki;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class InicioController implements Initializable {


    @FXML
    private MenuBar reservar;
    @FXML
    private Button Agregar;
    @FXML
    private Button Editar;
    @FXML
    private Button Iniciar;
    @FXML
    private Button Pausa;
    @FXML
    private Button Parar;
   

    @FXML
    private TableView<?> TabOperaciones;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private TableColumn<?, ?> NombreOp;
    @FXML
    private TableColumn<?, ?> NumTarea;
    @FXML
    private TableColumn<?, ?> Estado;
    

@Override
public void initialize(URL url, ResourceBundle rb) {
    try {
       
        Image imgEditar = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Editar.png"));
        ImageView vistaEditar = new ImageView(imgEditar);
        vistaEditar.setFitWidth(50);
        vistaEditar.setFitHeight(50);
        Editar.setGraphic(vistaEditar);

        Image imgMas = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Mas.png"));
        ImageView vistaMas = new ImageView(imgMas);
        vistaMas.setFitWidth(50);
        vistaMas.setFitHeight(50);
        Agregar.setGraphic(vistaMas);

        Image imgParar = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Parar.png"));
        ImageView vistaParar = new ImageView(imgParar);
        vistaParar.setFitWidth(50);
        vistaParar.setFitHeight(50);
        Parar.setGraphic(vistaParar);

        Image imgPausa = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/Pausa.png"));
        ImageView vistaPausa = new ImageView(imgPausa);
        vistaPausa.setFitWidth(50);
        vistaPausa.setFitHeight(50);
        Pausa.setGraphic(vistaPausa);

        Image imgIniciar = new Image(InicioController.class.getResourceAsStream("/mx/edu/uacm/is/slt/ds/forki/img/iniciar.png"));
        ImageView vistaIniciar = new ImageView(imgIniciar);
        vistaIniciar.setFitWidth(50);
        vistaIniciar.setFitHeight(50);
        Iniciar.setGraphic(vistaIniciar);

    } catch (Exception e) {
        System.out.println("Error al cargar la imagen: " + e.getMessage());
    }
}

   
    @FXML
    private void Agregar(ActionEvent event) throws IOException {
    FXMLLoader Cargando = new FXMLLoader(getClass().getResource("CrearOperacion.fxml"));
    Parent root = Cargando.load();

    // Crear nuevo Stage
    Stage nuevaVentana = new Stage();
    nuevaVentana.setScene(new Scene(root));
    nuevaVentana.setTitle("Crear Operación");

    // Hacerla modal
    nuevaVentana.initModality(Modality.WINDOW_MODAL);
    
    // Obtener el Stage actual (ventana padre)
    Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
    nuevaVentana.initOwner(ventanaActual);

    // Mostrar y bloquear ventana anterior
    nuevaVentana.showAndWait();
}

    @FXML
    private void Editar(ActionEvent event) throws IOException {
        
    FXMLLoader Cargando = new FXMLLoader(getClass().getResource("EditarOperaciones.fxml"));
    Parent root = Cargando.load();

    // Crear nuevo Stage
    Stage nuevaVentana = new Stage();
    nuevaVentana.setScene(new Scene(root));
    nuevaVentana.setTitle("Crear Operación");

    // Hacerla modal
    nuevaVentana.initModality(Modality.WINDOW_MODAL);
    
    // Obtener el Stage actual (ventana padre)
    Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
    nuevaVentana.initOwner(ventanaActual);

    // Mostrar y bloquear ventana anterior
    nuevaVentana.showAndWait();
        
    }

    @FXML
    private void Iniciar(ActionEvent event) {
    }

    @FXML
    private void Pausa(ActionEvent event) {
    }

    @FXML
    private void Parar(ActionEvent event) {
    }

    @FXML
    private void AcercaDe(ActionEvent event) {
        
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...  ");
        alert.setContentText("Nombre del sistema : Sistema Forki\n"
                + "Versión del sistema: Forki_V1\n"
                + "Fecha de lanzamiento del producto: 2025\n"
                + "Desarrolladores:\n"
                + "Arrieta Iglesias Alejandra\n"
                + "Del real Segura Jair\n"
                + "Ibarra de Santiago Michelle Pamela\n"
                + "Jaramillo Herrera Carolina\n"
                + "Jurado Laurrabaquio Fatima Daniela\n"
                + "Martinez Garcia Nestor Alejandro\n");
        alert.showAndWait();
        
    }
   

}

