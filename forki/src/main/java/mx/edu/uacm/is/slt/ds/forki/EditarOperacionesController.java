/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.forki;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
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

    /**
     * Initializes the controller class.
     */
    
    
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

    @FXML
    private void Ordenar(ActionEvent event) {
    }

    @FXML
    private void Eliminar(ActionEvent event) {
    }

    @FXML
    private void Aceptar(ActionEvent event) {
    }

    @FXML
    private void Cancelar(ActionEvent event) {
    }
    
}
