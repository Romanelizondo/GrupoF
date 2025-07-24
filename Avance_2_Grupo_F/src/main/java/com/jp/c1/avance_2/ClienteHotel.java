/* Proyecto Curso: Introducción a la Programación 
Integrantes: Meylin Irola, Justin Serrano, Freddy Retana, Roman Elizondo*/
package com.jp.c1.avance_1;

public class ClienteHotel {

    // Datos
    private String nombreCliente;
    private String correo;
    private String idCliente;
    private String telefono;

    // Constructor
    public ClienteHotel(String nombreCliente, String correo, String idCliente, String telefono) {
        this.nombreCliente = nombreCliente;
        this.correo = correo;
        this.idCliente = idCliente;
        this.telefono = telefono;
    }


    // Setters
    public void setNombreCliente(String nombreCompleto) {
        this.nombreCliente = nombreCompleto;
    }

    public void setCorreo(String emailCliente) {
        this.correo = emailCliente;
    }

    public void setIdCliente(String id) {
        this.idCliente = id;
    }

    public void setTelefono(String numeroTelefono) {
        this.telefono = numeroTelefono;
    }

    // Getters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

}
