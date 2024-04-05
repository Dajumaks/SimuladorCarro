/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.exceptions;

/**
 *
 * @author Danie
 */
public class AccidenteAlApagarVehiculoException extends RuntimeException {

    public AccidenteAlApagarVehiculoException() {
        super("El vehículo se accidentó al apagarlo debido a su alta velocidad.");
    }
}
