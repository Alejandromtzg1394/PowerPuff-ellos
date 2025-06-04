package mx.edu.uacm.is.slt.ds.forki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.forki.clases.Operacion;
import mx.edu.uacm.is.slt.ds.forki.clases.Tarea;

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
    private TableView<Operacion> TabOperaciones;
    @FXML
    private TableColumn<Operacion, Integer> ID;
    @FXML
    private TableColumn<Operacion, String> NombreOp;
    @FXML
    private TableColumn<Operacion, Integer> NumTarea;
    @FXML
    private TableColumn<Operacion, String> Estado;

    private ObservableList<Operacion> listaIoperacion = FXCollections.observableArrayList();
    private ObservableList<Tarea> listaTarea = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Estado.setCellFactory(column -> {
            TableCell<Operacion, String> cell = new TableCell<Operacion, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setStyle("");
                    } else {
                        setText(item);
                        switch (item.toUpperCase()) {
                            case "OCUPADO":
                                setStyle("-fx-background-color: orange; -fx-text-fill: white;");
                                break;
                            case "DISPONIBLE":
                                setStyle("-fx-background-color: green; -fx-text-fill: white;");
                                break;
                            case "DETENIDO":
                                setStyle("-fx-background-color: red; -fx-text-fill: black;");
                                break;
                            default:
                                setStyle("");
                                break;
                        }
                    }
                }
            };
            return cell;
        });

        // Configurar columnas con propiedades de Operacion
        ID.setCellValueFactory(new PropertyValueFactory<>("id_operacion"));
        NombreOp.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        Estado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        NumTarea.setCellValueFactory(cellData ->
            new SimpleIntegerProperty(
                cellData.getValue().getTareas() != null ? cellData.getValue().getTareas().size() : 0
            ).asObject()
        );

        // Asignar lista observable a la tabla
        TabOperaciones.setItems(listaIoperacion);

        // Cargar imágenes para botones
        cargarIconos();
    }

    private void cargarIconos() {
        try {
            ImageView vistaEditar = crearImageView("/mx/edu/uacm/is/slt/ds/forki/img/Editar.png");
            Editar.setGraphic(vistaEditar);

            ImageView vistaMas = crearImageView("/mx/edu/uacm/is/slt/ds/forki/img/Mas.png");
            Agregar.setGraphic(vistaMas);

            ImageView vistaParar = crearImageView("/mx/edu/uacm/is/slt/ds/forki/img/Parar.png");
            Parar.setGraphic(vistaParar);

            ImageView vistaPausa = crearImageView("/mx/edu/uacm/is/slt/ds/forki/img/Pausa.png");
            Pausa.setGraphic(vistaPausa);

            ImageView vistaIniciar = crearImageView("/mx/edu/uacm/is/slt/ds/forki/img/iniciar.png");
            Iniciar.setGraphic(vistaIniciar);

        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

 
    private ImageView crearImageView(String ruta) {
        Image img = new Image(getClass().getResourceAsStream(ruta));
        ImageView iv = new ImageView(img);
        iv.setFitWidth(50);
        iv.setFitHeight(50);
        return iv;
    }

    @FXML
    private void Agregar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearOperacion.fxml"));
        Parent root = loader.load();

        CrearOperacionController controller = loader.getController();
        controller.setInicioController(this); // conectar controladores

        Stage nuevaVentana = new Stage();
        nuevaVentana.setScene(new Scene(root));
        nuevaVentana.setTitle("Crear Operación");
        nuevaVentana.initModality(Modality.WINDOW_MODAL);

        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        nuevaVentana.initOwner(ventanaActual);

        nuevaVentana.showAndWait();
    }

    public void agregarOperacion(Operacion op) {
        listaIoperacion.add(op);
        System.out.println("---> Se agregó: " + op.getNombre());
        System.out.println("---> Total en lista: " + listaIoperacion.size());
    }

    @FXML
    private void Editar(ActionEvent event) throws IOException {
        Operacion operacionSeleccionada = TabOperaciones.getSelectionModel().getSelectedItem();
        if (operacionSeleccionada == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText("Ninguna operación seleccionada");
            alerta.setContentText("Por favor, seleccione una operación para editar.");
            alerta.showAndWait();
            return;
        }

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarOperaciones.fxml"));
        Parent root = loader.load();

        EditarOperacionesController controller = loader.getController();
        controller.setOperacion(operacionSeleccionada);
        controller.setTablaOperaciones(TabOperaciones); // <- pasar la tabla

        Stage ventana = new Stage();
        ventana.setScene(new Scene(root));
        ventana.setTitle("Editar Operación");
        ventana.initModality(Modality.WINDOW_MODAL);
        ventana.initOwner(((Node) event.getSource()).getScene().getWindow());
        ventana.showAndWait();
    }

    private void editarOperacionDesdeDobleClick(Operacion operacion) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarOperaciones.fxml"));
        Parent root = loader.load();

        EditarOperacionesController controller = loader.getController();
        controller.setOperacion(operacion);

        Stage ventana = new Stage();
        ventana.setScene(new Scene(root));
        ventana.setTitle("Editar Operación");
        ventana.initModality(Modality.WINDOW_MODAL);
        ventana.initOwner(TabOperaciones.getScene().getWindow());
        ventana.showAndWait();
    }

    @FXML
    private void Iniciar(ActionEvent event) {
        // (pendiente implementar)
    }

    @FXML
    private void Pausa(ActionEvent event) {
        //(pendiente implementar)
    }

    @FXML
    private void Parar(ActionEvent event) {
        //(pendiente implementar)
    }

    @FXML
    private void AcercaDe(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText(null);
        alert.setContentText("Nombre del sistema: Sistema Forki\n"
                + "Versión del sistema: Forki_V1\n"
                + "Fecha de lanzamiento del producto: 2025\n"
                + "Desarrolladores:\n"
                + "Arrieta Iglesias Alejandra\n"
                + "Del Real Segura Jair\n"
                + "Ibarra de Santiago Michelle Pamela\n"
                + "Jaramillo Herrera Carolina\n"
                + "Jurado Laurrabaquio Fatima Daniela\n"
                + "Martinez Garcia Nestor Alejandro\n");
        alert.showAndWait();
    }

    void agregarTarea(Tarea tarea) {
        listaTarea.add(tarea);
        System.out.println("---> Se agregó: " + tarea.getNombre());
        System.out.println("---> Total en lista: " + listaTarea.size());
    }
}
