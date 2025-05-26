/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.forki;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private TextField NombreOperacion;
    @FXML
    private TextField Precondicion;
    @FXML
    private TextField Postcondicion;
    @FXML
    private TextArea Instrucciones;
    
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
    private void Aceptar(ActionEvent event) {
    }

    @FXML
    private void Cancelar(ActionEvent event) {
    }

    @FXML
    private void Eliminar(ActionEvent event) {
    }
    
}
