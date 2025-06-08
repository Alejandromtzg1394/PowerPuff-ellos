/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uacm.is.slt.ds.forki.clases;
import javafx.concurrent.Task;
/**
 *
 * @author michelle
 * @author jair
 */
public class Tarea extends Task<Void>{
    private int id_tarea;
    private String nombre;
    private boolean asincrona;
    private int orden_sucesion;
    private String instrucciones;
    private String precondiciones;
    private String postcondiciones;
    
    //constructor vacio
    public Tarea() {
    }
    
   
    public enum EstadoTarea{
        EN_EJECUCION,
        PAUSADA,
        DETENIDA,
        COMPLETADA
    }
    
    private volatile EstadoTarea estadoActual;
    private volatile int progresoActual = 0;
    
    public Tarea(int id_tarea, String nombre, boolean asincrona, int orden_sucesion, String instrucciones, String precondiciones, String postcondiciones) {

        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.asincrona = asincrona;
        this.orden_sucesion = orden_sucesion;
        this.instrucciones = instrucciones;
        this.precondiciones = precondiciones;
        this.postcondiciones = postcondiciones;
        this.estadoActual=EstadoTarea.DETENIDA;
    }

    
    //geters y seters

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
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
    
    public EstadoTarea getEstadoActual(){
        return estadoActual;
    }
    
    //metodos
    
    public <T> void editar(T Tarea){
        //hola
    }

    public String obtener_estado(int id){
        return "regreso string";
    }

    public void suprimir(int id){
        //nada
    }

    public synchronized void detener(){
        if(this.estadoActual == EstadoTarea.EN_EJECUCION || this.estadoActual == EstadoTarea.PAUSADA){
            this.estadoActual=EstadoTarea.DETENIDA;
            this.progresoActual = 0;
            System.out.println("Tarea "+this.nombre+" detenida.");
        }else{
            System.out.println("Error: No se puede detener la tarea "+this.nombre+" desde el estado "+this.estadoActual);
        }
    }

    public synchronized void ejecutar(){//para iniciarla antes de hacer la llamada
        if(this.estadoActual == EstadoTarea.PAUSADA || this.estadoActual == EstadoTarea.DETENIDA ||  this.estadoActual == EstadoTarea.COMPLETADA){
            if(this.estadoActual==EstadoTarea.DETENIDA){
                this.progresoActual = 0;
                System.out.println("Tarea: "+this.nombre+" reiniciada desde el principio");
            }
            
            this.estadoActual=EstadoTarea.EN_EJECUCION;
            System.out.println("Tarea "+this.nombre+" iniciando/continuando ejecución.");
            
        }else{
            System.out.println("Error: No se puede iniciar la tarea "+this.nombre+" desde el estado "+ this.estadoActual);
        }
    }

    public synchronized void reanuda(){
        if(this.estadoActual == EstadoTarea.PAUSADA){
            this.estadoActual=EstadoTarea.EN_EJECUCION;
            System.out.println("Tarea "+this.nombre+" reanudada.");
        }else{
            System.out.println("Error: No se puede reanudar la tarea "+this.nombre+" desde el estado "+this.estadoActual);
        }
    }

    public synchronized void pausa(){
        if(this.estadoActual == EstadoTarea.EN_EJECUCION){
            this.estadoActual=EstadoTarea.PAUSADA;
            System.out.println("Tarea "+this.nombre+" pausada.");
        }else{
            System.out.println("Error: No se puede pausar la tarea "+this.nombre+" desde el estado "+this.estadoActual);
        }
    }
    
   
    @Override
    protected Void call() throws Exception{
        boolean termino=true;
        try{
            updateMessage("Preparando "+nombre+"...");
            updateProgress(progresoActual, 100);
            
            for(int i = progresoActual; i <= 100; i++){
                
                while(estadoActual == EstadoTarea.PAUSADA){
                    updateMessage(nombre+" pausa en "+i+"%");
                    Thread.sleep(200);
                }
                
                if(estadoActual == EstadoTarea.EN_EJECUCION){
                    this.progresoActual = i;
                    updateProgress(progresoActual, 100);
                    updateMessage("Ejecutando "+this.nombre+" ("+progresoActual+" %)");
                    Thread.sleep(100);//simular el tiempo de ejecucion de la tarea
                }else{
                    termino=false;
                    break;
                }
            }
            if(termino){
               this.estadoActual=EstadoTarea.COMPLETADA; 
            }
            
            
        }catch(InterruptedException e){
            this.estadoActual=EstadoTarea.DETENIDA;
            updateMessage(this.nombre+ " interrumpida(detenida).");
        }catch(Exception e){
            this.estadoActual = EstadoTarea.DETENIDA;
            updateMessage(this.nombre+" falló: "+e.getMessage());
        }
        return null;
    }
    

}
