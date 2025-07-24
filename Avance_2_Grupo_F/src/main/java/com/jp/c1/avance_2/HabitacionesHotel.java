/* Proyecto Curso: Introducción a la Programación 
Integrantes: Meylin Irola, Justin Serrano, Freddy Retana, Roman Elizondo*/
package com.jp.c1.avance_1;

public class HabitacionesHotel {

    // Atributos privados 
    private int piso;                
    private int numero;             
    private String tipo;            
    private double precioPorNoche;  // Precio 
    private boolean ocupada;        
    private String codigo;          

    // Constructor
    public HabitacionesHotel(int piso, int numero, String tipo, double precioPorNoche) {
        this.piso = piso;
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.ocupada = false; // Todas las habitaciones se crean inicialmente libres
        

        this.codigo = "P" + piso + "-H" + String.format("%02d", numero);
    }

    // Metodos get

    public int getPiso() {
        return piso;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public String getCodigo() {
        return codigo;
    }

    // Metodo set
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}