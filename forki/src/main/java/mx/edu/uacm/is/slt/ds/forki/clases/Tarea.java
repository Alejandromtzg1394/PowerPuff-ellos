/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.forki.clases;

/**
 *
 * @author michelle
 * @author jair
 */
public class Tarea {
    private int id_tarea;
    private String estado;
    private String nombre;
    private boolean asincrona;
    private int orden_sucesion;
    private String instrucciones;
    private String precondiciones;
    private String postcondiciones;
    
//constructor
    public Tarea(){
        
    }
    public Tarea(int id_tarea, String estado, String nombre, boolean asincrona, int orden_sucesion, String instrucciones, String precondiciones, String postcondiciones) {
        this.id_tarea = id_tarea;
        this.estado = estado;
        this.nombre = nombre;
        this.asincrona = asincrona;
        this.orden_sucesion = orden_sucesion;
        this.instrucciones = instrucciones;
        this.precondiciones = precondiciones;
        this.postcondiciones = postcondiciones;
    }

    
    //geters y seters

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAsincrona() {
        return asincrona;
    }

    public void setAsincrona(boolean asincrona) {
        this.asincrona = asincrona;
    }

    public int getOrden_sucesion() {
        return orden_sucesion;
    }

    public void setOrden_sucesion(int orden_sucesion) {
        this.orden_sucesion = orden_sucesion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
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
    
    
    //metodos
    
    public <T> void editar(T Tarea){
        //hola
    }

    public String obtener_estado(int id){
        return "regreso string";
    }

    public void cambiar_estado(int id, String estado){
        //nada
    }

    public void suprimir(int id){
        //nada
    }

    public void detener(int id){
        //nada
    }

    public void ejecutar(int id){
        //me ejecuto
    }

    public void reanuda(int id){
        //me reanudo
    }

    public void pausa(int id){
        //entro en pausa
    }

}
