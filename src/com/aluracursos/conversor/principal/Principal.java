package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.servicio.ConversorMonedas;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal para el conversor de monedas.
 */
public class Principal {

    private static final int DOLAR_A_PESO_ARGENTINO = 1;
    private static final int PESO_ARGENTINO_A_DOLAR = 2;
    private static final int DOLAR_A_REAL_BRASILENO = 3;
    private static final int REAL_BRASILENO_A_DOLAR = 4;
    private static final int DOLAR_A_PESO_COLOMBIANO = 5;
    private static final int PESO_COLOMBIANO_A_DOLAR = 6;
    private static final int SALIR = 7;

    private static List<String> historial = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();

        mostrarMensajeBienvenida();

        while (true) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();
                if (opcion == SALIR) {
                    mostrarMensajeDespedida();
                    mostrarHistorial();
                    break;
                }
                procesarOpcion(opcion, scanner, conversor);
            } catch (InputMismatchException e) {
                System.out.println("\033[1;31mEntrada no válida. Por favor, ingrese un número.\033[0m");
                scanner.next(); // Limpiar la entrada no válida
            }
        }

        scanner.close();
    }

    private static void mostrarMensajeBienvenida() {
        System.out.println("\033[1;34m********************************************\033[0m");
        System.out.println("\033[1;32mBienvenido/a al Conversor de Moneda =]\033[0m");
    }

    private static void mostrarMensajeDespedida() {
        System.out.println("\033[1;31mSaliendo...\033[0m");
    }

    private static void mostrarMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("\033[1;34m********************************************\033[0m\n")
                .append("\033[1;33mSeleccione una opción:\033[0m\n")
                .append("\033[1;34m********************************************\033[0m\n")
                .append("1) Dólar => Peso argentino\n")
                .append("2) Peso argentino => Dólar\n")
                .append("3) Dólar => Real brasileño\n")
                .append("4) Real brasileño => Dólar\n")
                .append("5) Dólar => Peso colombiano\n")
                .append("6) Peso colombiano => Dólar\n")
                .append("7) Salir\n")
                .append("\033[1;34m********************************************\033[0m\n")
                .append("\033[1;33mElija una opción válida (número del menú): \033[0m");
        System.out.print(menu.toString());
    }

    private static void procesarOpcion(int opcion, Scanner scanner, ConversorMonedas conversor) {
        double cantidad = 0;
        String[] monedas = obtenerMonedas(opcion);
        if (monedas == null) {
            System.out.println("\033[1;31mOpción no válida.\033[0m");
            return;
        }

        System.out.print("\033[1;33mIngrese la cantidad a convertir: \033[0m");
        try {
            String entrada = scanner.next().trim().replace(",", ".");
            cantidad = Double.parseDouble(entrada);
            if (cantidad <= 0) {
                System.out.println("\033[1;31mLa cantidad debe ser mayor a cero.\033[0m");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("\033[1;31mEntrada no válida. Por favor, ingrese un número del menú.\033[0m");
            return;
        }

        double resultado = conversor.convertirMoneda(monedas[0], monedas[1], cantidad);
        if (resultado != -1) {
            String conversion = cantidad + " " + monedas[0] + " => " + resultado + " " + monedas[1];
            historial.add(conversion);
            System.out.println("\033[1;32mResultado: " + conversion + "\033[0m");
        }
    }

    private static void mostrarHistorial() {
        System.out.println("\033[1;34m********************************************\033[0m");
        System.out.println("\033[1;32mHistorial de Conversiones:\033[0m");
        for (String conversion : historial) {
            System.out.println(conversion);
        }
        System.out.println("\033[1;34m********************************************\033[0m");
    }

    private static String[] obtenerMonedas(int opcion) {
        switch (opcion) {
            case DOLAR_A_PESO_ARGENTINO:
                return new String[]{"USD", "ARS"};
            case PESO_ARGENTINO_A_DOLAR:
                return new String[]{"ARS", "USD"};
            case DOLAR_A_REAL_BRASILENO:
                return new String[]{"USD", "BRL"};
            case REAL_BRASILENO_A_DOLAR:
                return new String[]{"BRL", "USD"};
            case DOLAR_A_PESO_COLOMBIANO:
                return new String[]{"USD", "COP"};
            case PESO_COLOMBIANO_A_DOLAR:
                return new String[]{"COP", "USD"};
            default:
                return null;
        }
    }
}
