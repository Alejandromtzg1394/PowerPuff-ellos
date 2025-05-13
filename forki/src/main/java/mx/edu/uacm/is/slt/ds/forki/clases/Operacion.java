/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.forki.clases;

import java.util.List;

/**
 *
 * @author arral
 */
public class Operacion implements Gestion {
    private Integer id_operacion;
    private Integer id_tarea;
    public String nombre;
    private String estado;
    public List<Integer> tareas;
    public String precondiciones;
    public String postcondiciones;

    public Integer getId_operacion() {
        return id_operacion;
    }

    private void setId_operacion(Integer id_operacion) {
        this.id_operacion = id_operacion;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    private void setId_tarea(Integer id_tarea) {
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

    private void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Integer> getTareas() {
        return tareas;
    }

    public void setTareas(List<Integer> tareas) {
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
    

    public void editar (){
        
    }
    
    public void cambiar_estado(Integer id_operacion, String estado){
        
    }
    
    private void pausa (Integer id_operacion ){
        
    }
    
    private void reanudar (Integer id_operacion ){
        
    }
    
    private void ejecuta (Integer id_operacion){
        
    }
    
    private void suprimir (Integer id_operacion){
        
    }
    
    private void detener (Integer id_operacion){
        
    }
    
    public void editar_tarea(Integer id_tarea ){
        
    }
    
    public void suprimir_tarea(Integer id_tarea){
        
    }
    
    public String solicitar_estado_tarea(Integer id_tarea){
        return "a";
    }
    
    public void cambiar_estado_tareas(Integer id_tarea, String estado){
        
    }
    
    public Integer crear_tarea(){
        return 0;
    }
    
    public void pausar_tarea(Integer id_tarea){
        
    }
    
    public void reanudar_tarea(Integer id_tarea){
        
    }
    
    public void detener_tarea(Integer id_tarea){
        
    }

    @Override
    public Integer crear_operacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar_operacion(Integer id_operacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar_tarea(Integer id_operacion, Integer id_tarea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String solicitar_estado_operacion(Integer id_operacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void solicita_cambiar_estado_operacion(Integer id_operacion, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
