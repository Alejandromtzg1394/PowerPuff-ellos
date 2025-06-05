/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.forki.clases;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author arral
 */
public class Operacion implements Gestion {

    private int id_operacion;
    private Integer id_tarea;
    private String nombre;
    private String estado;
    private ObservableList<Tarea> tareas = FXCollections.observableArrayList();
    private String precondiciones;
    private String postcondiciones;

    // Getters y Setters públicos necesarios para TableView

    public int getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ObservableList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ObservableList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public String getPrecondiciones() {
        return precondiciones;
    }

    public void setPrecondiciones(String precondiciones) {
        this.precondiciones = precondiciones;
    }

    public String getPostcondiciones() {
        return postcondiciones;
    }

    public void setPostcondiciones(String postcondiciones) {
        this.postcondiciones = postcondiciones;
    }

    // Métodos definidos por la interfaz Gestion
    @Override
    public Integer crear_operacion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar_operacion(Integer id_operacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar_tarea(Integer id_operacion, Integer id_tarea) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String solicitar_estado_operacion(Integer id_operacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void solicita_cambiar_estado_operacion(Integer id_operacion, String estado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Otros métodos relacionados con tareas y operaciones
    public void editar() {
        // Implementación pendiente
    }

    public void cambiar_estado(Integer id_operacion, String estado) {
        // Implementación pendiente
    }

    public void pausa(Integer id_operacion) {
        // Implementación pendiente
    }

    public void reanudar(Integer id_operacion) {
        // Implementación pendiente
    }

    public void ejecuta(Integer id_operacion) {
        // Implementación pendiente
    }

    public void suprimir(Integer id_operacion) {
        // Implementación pendiente
    }

    public void detener(Integer id_operacion) {
        // Implementación pendiente
    }

    public void editar_tarea(Integer id_tarea) {
        // Implementación pendiente
    }

    public void suprimir_tarea(Integer id_tarea) {
        // Implementación pendiente
    }

    public String solicitar_estado_tarea(Integer id_tarea) {
        return "a";
    }

    public void cambiar_estado_tareas(Integer id_tarea, String estado) {
        // Implementación pendiente
    }

    public Integer crear_tarea() {
        return 0;
    }

    public void pausar_tarea(Integer id_tarea) {
        // Implementación pendiente
    }

    public void reanudar_tarea(Integer id_tarea) {
        // Implementación pendiente
    }

    public void detener_tarea(Integer id_tarea) {
        // Implementación pendiente
    }
}