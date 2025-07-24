/* Proyecto Curso: Introducción a la Programación 
Integrantes: Meylin Irola, Justin Serrano, Freddy Retana, Roman Elizondo*/
package com.jp.c1.avance_1;

public class ReservaHabitacion {

    // Atributos privados 
    private String codigoReserva;               
    private ClienteHotel cliente;               
    private HabitacionesHotel habitacion;       
    private int noches;                         
    private double total;                       

    // Constructor
    public ReservaHabitacion(String codigoReserva, ClienteHotel cliente, HabitacionesHotel habitacion, int noches) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.noches = noches;
        this.total = noches * habitacion.getPrecioPorNoche();
    }

    // Metodos get

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public ClienteHotel getCliente() {
        return cliente;
    }

    public HabitacionesHotel getHabitacion() {
        return habitacion;
    }

    public int getNoches() {
        return noches;
    }

    public double getTotal() {
        return total;
    }
}
