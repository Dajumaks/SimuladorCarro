/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.exceptions;

/**
 *
 * @author Danie
 */
public class FrenarBruscamenteException extends RuntimeException {
    public FrenarBruscamenteException(){
        ////super sirve llamar el contrutcor del padre
        super("El vehículo patinó debido a una frenada brusca");
    }
}