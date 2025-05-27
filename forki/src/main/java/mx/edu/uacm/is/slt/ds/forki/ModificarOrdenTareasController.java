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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alejandro
 */
public class ModificarOrdenTareasController implements Initializable {

    @FXML
    private MenuBar MenuHome;
    @FXML
    private TableView<?> TabOperaciones;
    @FXML
    private TableColumn<?, ?> NombreOp;
    @FXML
    private TableColumn<?, ?> NumTarea;
    @FXML
    private TableColumn<?, ?> Estado;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;
    
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
    private void AcercaDe(ActionEvent event) {
    }

    @FXML
    private void Aceptar(ActionEvent event) {
    }

    @FXML
    private void Cancelar(ActionEvent event) {
    }
    
}
