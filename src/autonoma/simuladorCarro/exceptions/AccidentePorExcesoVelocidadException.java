/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.exceptions;

/**
 *
 * @author Danie
 */
public class AccidentePorExcesoVelocidadException extends RuntimeException {
     public AccidentePorExcesoVelocidadException(){
         
        ////super sirve llamar el contrutcor del padre
        super("El vehículo se accidentó debido a una aceleración excesiva.");
    }
}
