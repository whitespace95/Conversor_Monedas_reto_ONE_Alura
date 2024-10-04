package com.aluracursos.conversor.servicio;

import com.google.gson.JsonObject;

/**
 * Servicio para convertir monedas utilizando tasas de cambio obtenidas de una API.
 */
public class ConversorMonedas {

    private final ApiServicio apiServicio;

    /**
     * Constructor que inicializa el servicio de API.
     */
    public ConversorMonedas() {
        this.apiServicio = new ApiServicio();
    }

    /**
     * Convierte una cantidad de una moneda a otra.
     *
     * @param monedaOrigen el código de la moneda de origen
     * @param monedaDestino el código de la moneda de destino
     * @param cantidad la cantidad a convertir
     * @return el monto convertido, o -1 si no se pudo obtener la tasa de cambio
     */
    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a convertir debe ser mayor a cero.");
            return -1;
        }

        try {
            JsonObject tasasDeCambio = apiServicio.obtenerTasasDeCambio(monedaOrigen);
            if (tasasDeCambio != null) {
                double tasaDeCambio = obtenerTasaDeCambio(tasasDeCambio, monedaDestino);
                if (tasaDeCambio > 0) {
                    return cantidad * tasaDeCambio;
                } else {
                    System.out.println("No se encontró una tasa de cambio válida para " + monedaDestino);
                }
            } else {
                System.out.println("No se pudo obtener las tasas de cambio.");
            }
        } catch (NullPointerException e) {
            System.out.println("Error: JSON no contiene las tasas de conversión necesarias.");
        } catch (Exception e) {
            System.out.println("Error al convertir moneda: " + e.getMessage());
        }

        return -1;
    }

    /**
     * Obtiene la tasa de cambio para una moneda de destino específica.
     *
     * @param tasasDeCambio el objeto JSON que contiene las tasas de cambio
     * @param monedaDestino el código de la moneda de destino
     * @return la tasa de cambio, o -1 si no se encuentra la tasa de cambio
     */
    private double obtenerTasaDeCambio(JsonObject tasasDeCambio, String monedaDestino) {
        try {
            JsonObject tasasDeConversion = tasasDeCambio.getAsJsonObject("conversion_rates");
            if (tasasDeConversion.has(monedaDestino)) {
                return tasasDeConversion.get(monedaDestino).getAsDouble();
            } else {
                System.out.println("Tasa de cambio no disponible para: " + monedaDestino);
            }
        } catch (NullPointerException e) {
            System.out.println("Error: JSON no contiene las tasas de conversión necesarias.");
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
        return -1;
    }
}
