/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.models;

import java.awt.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Danie
 */
public class Taller {
    
    public static Vehiculo crearVehiculoDesdeArchivo() {
                Path archivo = Paths.get("");

    try{
        List<String> lineasTexto = Files.readAllLines(archivo);
        String nombreLlanta = "";
        String nombreMotor = "";
        double limiteLlantaMotor = "";
        double limiteLlant = 0;
        int limiteVelocidad = 0;

        for (String linea : lineasTexto){
            String[] partes = linea.split(" ");
            if (partes.length >= 2){
                String tipo = partes[0];
                String nombre = partes[1];
                if (tipo.equals("Motor:")){
                    nombreMotor = nombre;
                } else if (tipo.equals("Llanta:")){
                    nombreLlanta = nombre;
                } else{
                    if (nombreMotor.equals("1000") && tipo.equals("1000")){
                        limiteVelocidad = Integer.parseInt(nombre);
                    } else if (nombreMotor.equals("2000") && tipo.equals("2000")){
                        limiteVelocidad = Integer.parseInt(nombre);
                    } else if (nombreMotor.equals("3000") && tipo.equals("3000")){
                        limiteVelocidad = Integer.parseInt(nombre);
                    } else if (nombreLlanta.equals("Buenas") && tipo.equals("Buenas")){
                        limiteLlanta = Double.parseDouble(nombre);
                    } else if (nombreLlanta.equals("Bonitas") && tipo.equals("Bonitas")){
                        limiteLlanta = Double.parseDouble(nombre);
                    } else if (nombreLlanta.equals("Baratas") && tipo.equals("Baratas")){
                        limiteLlanta = Double.parseDouble(nombre);
                    }
                }
            }
        }

        Motor tipoMotor = new Motor(limiteVelocidad);
        Llanta tipoLlanta = new Llanta(limiteLlanta);
        return new Vehiculo(tipoMotor, tipoLlanta);
    } catch (IOException e) {
        e.printStackTrace();
    }
        return null;
    }
}