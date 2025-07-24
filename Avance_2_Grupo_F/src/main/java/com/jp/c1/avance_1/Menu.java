/* Proyecto Curso: Introducción a la Programación 
Integrantes: Meylin Irola, Justin Serrano, Freddy Retana, Roman Elizondo*/
package com.jp.c1.avance_1;

import java.util.Random;

import javax.swing.JOptionPane;

public class Menu {

    private static final int MAX_CLIENTES = 100;
    private static ClienteHotel[] listaClientes = new ClienteHotel[MAX_CLIENTES];
    private static int cantidadClientes = 0;
    private static int contadorIdClientes = 1;

    private static final int MAX_HABITACIONES = 50;
    private static HabitacionesHotel[] listaHabitaciones = new HabitacionesHotel[MAX_HABITACIONES];
    private static int cantidadHabitaciones = 0;

    private static final int MAX_RESERVAS = 100;
    private static ReservaHabitacion[] listaReservas = new ReservaHabitacion[MAX_RESERVAS];
    private static int cantidadReservas = 0;
    private static int contadorIdReserva = 1;

    public static void mostrarMenu() {
        int opcion;

        do {
            String input = JOptionPane.showInputDialog(
                    " Menu Principal - Hotel Costa Sol\n"
                            + "1. Registro de Clientes\n"
                            + "2. Reservas de Habitaciones\n"
                            + "3. Cancelaciones y Salidas\n"
                            + "4. Modulo de Reportes\n"
                            + "5. Salir\n\n"
                            + "Seleccione una opcion:");

            if (input == null)
                break;

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        registrarCliente();
                        break;
                    case 2:
                        hacerReserva();
                        break;
                    case 3:
                        // cancelarSalida();
                        break;
                    case 4:
                        // mostrarReportes();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                        return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un unmero.");
            }
        } while (true);
    }

    // Registro de Clientes

    private static String generarIdCliente() {
        String id = String.format("CL-%04d", contadorIdClientes); // id formato -> CL-0XXX
        contadorIdClientes++;
        return id;
    }

    private static void registrarCliente() {
        if (cantidadClientes >= MAX_CLIENTES) {
            JOptionPane.showMessageDialog(null, "Limite de clientes alcanzado.");
            return;
        }

        String id = generarIdCliente();

        // Validacion de Id
        for (int i = 0; i < cantidadClientes; i++) {
            if (listaClientes[i].getIdCliente().equals(id)) {
                JOptionPane.showMessageDialog(null, "Error: ID duplicado.");
                return;
            }
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        if (nombre == null || nombre.isBlank())
            return;

        String correo = JOptionPane.showInputDialog("Ingrese el correo:");
        if (correo == null || correo.isBlank())
            return;

        String telefono = JOptionPane.showInputDialog("Ingrese el telefono:");
        if (telefono == null || telefono.isBlank())
            return;

        ClienteHotel nuevo = new ClienteHotel(nombre, correo, id, telefono);
        listaClientes[cantidadClientes] = nuevo;
        cantidadClientes++;

        JOptionPane.showMessageDialog(null, "Cliente registrado con exito.\nID asignado: " + id);
    }

    // Método para hacer reservas
    private static void hacerReserva() {
        String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
        if (idCliente == null || idCliente.isBlank())
            return;

        ClienteHotel cliente = null;
        for (int i = 0; i < cantidadClientes; i++) {
            if (listaClientes[i].getIdCliente().equals(idCliente)) {
                cliente = listaClientes[i];
                break;
            }
        }
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            return;
        }

        // Verificar si ya tiene una reserva activa
        for (int i = 0; i < cantidadReservas; i++) {
            if (listaReservas[i].getCliente().getIdCliente().equals(idCliente)) {
                JOptionPane.showMessageDialog(null, "El cliente ya tiene una reserva activa.");
                return;
            }
        }

        String fechaEntrada = JOptionPane.showInputDialog("Ingrese la fecha de entrada (ejemplo: 23-07-2025):");
        if (fechaEntrada == null || fechaEntrada.isBlank())
            return;

        String fechaSalida = JOptionPane.showInputDialog("Ingrese la fecha de salida (ejemplo: 25-07-2025):");
        if (fechaSalida == null || fechaSalida.isBlank())
            return;

        String tipoHabitacion = JOptionPane
                .showInputDialog("Ingrese el tipo de habitación (ejemplo: Sencilla, Doble, Suite):");
        if (tipoHabitacion == null || tipoHabitacion.isBlank())
            return;

        // Buscar habitación libre del tipo solicitado
        HabitacionesHotel habitacionLibre = null;
        for (int i = 0; i < cantidadHabitaciones; i++) {
            HabitacionesHotel h = listaHabitaciones[i];
            if (!h.isOcupada() && h.getTipo().equalsIgnoreCase(tipoHabitacion)) {
                habitacionLibre = h;
                break;
            }
        }
        if (habitacionLibre == null) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones libres de ese tipo.");
            return;
        }

        // Calcular noches
        int noches = 1;
        try {
            noches = calcularNoches(fechaEntrada, fechaSalida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fechas inválidas.");
            return;
        }

        String codigoReserva = String.format("RSV-%04d", contadorIdReserva++);
        ReservaHabitacion reserva = new ReservaHabitacion(codigoReserva, cliente, habitacionLibre, noches);
        listaReservas[cantidadReservas++] = reserva;
        habitacionLibre.setOcupada(true);

        JOptionPane.showMessageDialog(null, "Reserva realizada.\nCódigo: " + codigoReserva +
                "\nHabitación: " + habitacionLibre.getCodigo() +
                "\nNoches: " + noches +
                "\nTotal: ₡" + reserva.getTotal());
    }

    // Método auxiliar para calcular noches (simple, sin validación real)
    private static int calcularNoches(String entrada, String salida) {
        String[] e = entrada.split("-");
        String[] s = salida.split("-");
        int diaE = Integer.parseInt(e[0]); // DD
        int diaS = Integer.parseInt(s[0]); // DD
        return Math.max(1, diaS - diaE);
    }

}
