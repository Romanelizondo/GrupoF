/* Proyecto Curso: Introducción a la Programación 
Integrantes: Meylin Irola, Justin Serrano, Freddy Retana, Roman Elizondo*/
package com.jp.c1.avance_1;

import java.util.Random;

import javax.swing.JOptionPane;
        
public class Menu {
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

            if (input == null) break;

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        //registrarCliente();
                    case 2: 
                        //hacerReserva();
                    case 3:
                        //cancelarSalida();
                    case 4:
                        //mostrarReportes();
                    case 5: 
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                        return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un unmero.");
            }
        } while (true);
    }
}
