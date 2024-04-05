/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.exceptions;

/**
 *
 * @author Danie
 */
public class VehiculoYaApagadoException extends RuntimeException {

    public VehiculoYaApagadoException() {
        ////super sirve llamar el contrutcor del padre
        super("El vehiculo ya está apagado");
    }
}
