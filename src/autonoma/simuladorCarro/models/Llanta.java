/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorCarro.models;

/**
 *
 * @author Danie
 */
// Definición de la clase Llantas
public class Llanta {
    private String tipo;
    private int velocidadMaxima;
    private int diametro;
    

    // Constructor
    public Llanta(String tipo, int velocidadMaxima, int diametro) {
        this.tipo = tipo;
        this.velocidadMaxima = velocidadMaxima;
        this.diametro = diametro;
    }

    Llanta(double limiteLlanta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public int getDiametro() {
        return diametro;
    }

    // Métodos getter
    public String getTipo() {
        return tipo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    int getLimiteFrenado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
