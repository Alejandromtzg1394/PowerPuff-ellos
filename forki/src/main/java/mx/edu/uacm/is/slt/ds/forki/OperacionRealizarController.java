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
public class OperacionRealizarController implements Initializable {

    @FXML
    private MenuBar MenuHome;
    @FXML
    private TableView<?> TabOperaciones;
    @FXML
    private TableColumn<?, ?> NombreOp;
    @FXML
    private TableColumn<?, ?> Estado;
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
    private void Agregar(ActionEvent event) {
    }

    @FXML
    private void Editar(ActionEvent event) {
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
    
}
