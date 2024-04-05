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
public class Vehiculo {

    // Atributos
    private Motor motor;
    private boolean encendido;
    private double velocidad;
    private boolean enMovimiento;
    private double velocidadMaxima;

    // Constructor
    public Vehiculo(Motor motor) {
        this.motor = motor;
        this.encendido = false;
        this.velocidad = 0;
        this.enMovimiento = false;
        this.velocidadMaxima = 60;
    }

    Vehiculo(Motor tipoMotor, Llanta tipoLlanta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Métodos de acceso
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double nVelocidad) {
        this.velocidad = nVelocidad;

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

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void accidentarVehiculo() {
        System.out.println("El vehículo ha tenido un accidente.");
    }

    public void encender() throws VehiculoYaEncendidoException {
        if (encendido) {
            throw new VehiculoYaEncendidoException();
        } else {
            encendido = true;
            System.out.println("El vehículo ha sido encendido.");
        }
    }

    public void apagar() throws VehiculoYaApagadoException {
        if (!encendido) {
            throw new VehiculoYaApagadoException();
        } else {
            encendido = false;
            velocidad = 0;
            System.out.println("El vehículo ha sido apagado.");
        }
    }

    public void acelerar(double cantidad, double velocidad) throws CapacidadMotorException {
        double nVelocidad = this.velocidad + velocidad;
        this.motor.validarVelocidadMaxima(nVelocidad);
        this.setVelocidad(nVelocidad);

        if (cantidad > motor.getCapacidad()) {
            throw new CapacidadMotorException();
        }
        if (velocidad > 30) {
            throw new AccidentePorExcesoVelocidadException();
        }

    }

    public void frenar(double cantidad, double magnitud) throws CapacidadMotorException, FrenarBruscamenteException, AccidentePorExcesoVelocidadException, VehiculoApagadoException {
        double nuevaVelocidad = this.velocidad - magnitud;
        if (nuevaVelocidad < 0) {
            nuevaVelocidad = 0; // Velocidad mínima es 0 km/h
        }
        this.motor.validarVelocidadMaxima(nuevaVelocidad);
        this.setVelocidad(nuevaVelocidad);

        if (!encendido) {
            throw new VehiculoApagadoException("El vehículo está apagado, no se puede frenar.");
        }
        if (cantidad > 30) {
            throw new FrenarBruscamenteException();
        }
        // Comprobar si se produce un patinaje al frenar bruscamente
        if (magnitud > velocidad) {
            throw new AccidentePorExcesoVelocidadException();
        }
    }

}
