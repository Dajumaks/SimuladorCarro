/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.exceptions;

/**
 *
 * @author Danie
 */
public class CapacidadMotorException extends RuntimeException {
    public CapacidadMotorException(){
        ////super sirve llamar el contrutcor del padre
        super("La velocidad excedió el limite permitido  por el motor");
    }
    
}
