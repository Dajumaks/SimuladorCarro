/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.models;

import autonoma.simuladorCarro.exceptions.AccidentePorExcesoVelocidadException;
import autonoma.simuladorCarro.exceptions.CapacidadMotorException;
import autonoma.simuladorCarro.exceptions.FrenarBruscamenteException;
import autonoma.simuladorCarro.exceptions.VehiculoApagadoException;
import autonoma.simuladorCarro.exceptions.VehiculoYaApagadoException;
import autonoma.simuladorCarro.exceptions.VehiculoYaEncendidoException;

/**
 *
 * @author Danie
 */
public class Simulador {

    // Atributos
    private Motor motor;
    private Vehiculo vehiculo;
    private boolean encendido;
    private boolean enMovimiento;
    private double velocidad;

    // Constructor
    public Simulador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.encendido = false; // Por defecto, el motor está apagado al iniciar el simulador
        this.enMovimiento = false; // Por defecto, el vehículo no está en movimiento al iniciar el simulador
        this.velocidad = 0; // Por defecto, la velocidad inicial es 0 al iniciar el simulador
    }



    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    
        // Método para encender el motor
    public void encenderMotor() {
        motor.encender();
        this.encendido = true;
    }
     /////// Método para encender el vehiculo
        public void encenderVehiculo(){
        this.vehiculo.encender();
    }
    // Método para apagar el motor
    public void apagarMotor() throws VehiculoYaApagadoException {
        if (!encendido) {
            throw new VehiculoYaApagadoException();
        } else {
            motor.apagar();
            this.encendido = false;
        }
    }

    // Método para acelerar el vehículo
public void acelerar(double cantidadAceleracion) throws CapacidadMotorException, VehiculoApagadoException {
    try {
        if (!encendido) {
            throw new VehiculoApagadoException("El vehículo está apagado, no se puede acelerar.");
        }
        vehiculo.acelerar(cantidadAceleracion, velocidad); // Pasar la cantidad de aceleración y la velocidad
    } catch (VehiculoApagadoException e) {
        System.out.println("Error al acelerar: " + e.getMessage());
        throw e; // Relanzar la excepción para que pueda ser manejada en niveles superiores
    }
}

    // Método para frenar el vehículo
public void frenar(double cantidadFrenado) throws CapacidadMotorException, VehiculoApagadoException, FrenarBruscamenteException, AccidentePorExcesoVelocidadException {
    try {
        if (!encendido) {
            throw new VehiculoApagadoException("El vehículo está apagado, no se puede frenar.");
        }
        vehiculo.frenar(cantidadFrenado, velocidad); // Pasar la cantidad de frenado y la velocidad
    } catch (VehiculoApagadoException | FrenarBruscamenteException | AccidentePorExcesoVelocidadException e) {
        System.out.println("Error al frenar: " + e.getMessage());
        throw e; // Relanzar la excepción para que pueda ser manejada en niveles superiores
    }
}


    // Método para verificar si el motor está encendido
    public boolean estaEncendido() {
        return encendido;
    }

    // Método para verificar si el vehículo está en movimiento
    public boolean estaEnMovimiento() {
        return enMovimiento;
    }


}

