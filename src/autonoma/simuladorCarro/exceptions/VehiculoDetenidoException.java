/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.exceptions;

/**
 *
 * @author Danie
 */
public class VehiculoDetenidoException extends RuntimeException {

    public VehiculoDetenidoException() {
        ////super sirve llamar el contrutcor del padre
        super("Un vehículo detenido no se puede frenar, su acción no surte efecto.");
    }
}
