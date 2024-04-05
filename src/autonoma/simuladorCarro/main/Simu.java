package autonoma.simuladorCarro.main;

import autonoma.simuladorCarro.exceptions.CapacidadMotorException;
import autonoma.simuladorCarro.exceptions.VehiculoApagadoException;
import autonoma.simuladorCarro.exceptions.VehiculoYaApagadoException;
import autonoma.simuladorCarro.exceptions.VehiculoYaEncendidoException;
import autonoma.simuladorCarro.exceptions.AccidenteAlApagarVehiculoException;
import autonoma.simuladorCarro.exceptions.AccidentePorExcesoVelocidadException;
import autonoma.simuladorCarro.exceptions.FrenarBruscamenteException;
import autonoma.simuladorCarro.models.Motor;
import autonoma.simuladorCarro.models.Simulador;
import autonoma.simuladorCarro.models.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author Danie
 */
public class Simu {

    public static void main(String[] args) {
        Motor motor = new Motor(100);
        Vehiculo vehiculo = new Vehiculo(motor);

        Simulador simulador = new Simulador(vehiculo);

        simulador.encenderVehiculo();

        /// Un vehículo encendido no se puede encender de nuevo.
        try {
            vehiculo.encender();
            // Intentar encenderlo nuevamente (debería lanzar una excepción)
            vehiculo.encender();
        } catch (VehiculoYaEncendidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //// Un vehículo apagado no se puede apagar de nuevo.
        try {
            vehiculo.apagar();
            vehiculo.apagar(); // Intenta apagar el vehículo nuevamente
        } catch (VehiculoYaApagadoException e) {
            System.out.println("Error: El vehículo ya está apagado.");
        } catch (AccidenteAlApagarVehiculoException e) {
            System.out.println("Error: El vehículo se accidentó al apagarlo debido a su alta velocidad.");
        }

        //// Un vehículo apagado no se puede acelerar o frenar.
       try {
            vehiculo.acelerar(50, 10);
        } catch (AccidentePorExcesoVelocidadException e) {
            System.out.println("Error al acelerar debido a exceso de velocidad: " + e.getMessage());
        } catch (CapacidadMotorException e) {
            System.out.println("Error al acelerar: " + e.getMessage());
        }

        // Intentar frenar un vehículo apagado (debería lanzar una excepción)
        try {
            vehiculo.frenar(50, 10);
        } catch (VehiculoApagadoException e) {
            System.out.println("Error al frenar: " + e.getMessage());
        } catch (FrenarBruscamenteException e) {
            System.out.println("Error al frenar bruscamente: " + e.getMessage());
        } catch (AccidentePorExcesoVelocidadException e) {
            System.out.println("Error al frenar debido a exceso de velocidad: " + e.getMessage());
        } catch (CapacidadMotorException e) {
            System.out.println("Error al frenar: " + e.getMessage());
        }
    }
}
