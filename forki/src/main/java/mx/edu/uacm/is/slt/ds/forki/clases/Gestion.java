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
public interface Gestion {
    public Integer crear_operacion();
    public void editar_operacion(Integer id_operacion);
    public Integer crear_tarea();
    public void editar_tarea(Integer id_operacion, Integer id_tarea);
    public String solicitar_estado_operacion(Integer id_operacion);
    public void solicita_cambiar_estado_operacion(Integer id_operacion, String estado);
    
    
}
