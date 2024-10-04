package com.aluracursos.conversor.modelo;

/**
 * Representa una tasa de cambio entre dos monedas.
 */
public class TasaDeCambio {
    private final String monedaBase; // Código de la moneda base
    private final String monedaDestino; // Código de la moneda de destino
    private final double tasa; // Tasa de cambio

    /**
     * Crea una nueva instancia de TasaDeCambio.
     *
     * @param monedaBase el código de la moneda base
     * @param monedaDestino el código de la moneda de destino
     * @param tasa la tasa de cambio
     * @throws IllegalArgumentException si alguno de los parámetros es nulo o vacío, o si la tasa es negativa
     */
    public TasaDeCambio(String monedaBase, String monedaDestino, double tasa) {
        if (monedaBase == null || monedaBase.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda base no puede ser nulo o vacío");
        }
        if (monedaDestino == null || monedaDestino.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda de destino no puede ser nulo o vacío");
        }
        if (tasa <= 0) {
            throw new IllegalArgumentException("La tasa de cambio debe ser positiva");
        }
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
    }

    /**
     * Obtiene el código de la moneda base.
     *
     * @return el código de la moneda base
     */
    public String getMonedaBase() {
        return monedaBase;
    }

    /**
     * Obtiene el código de la moneda de destino.
     *
     * @return el código de la moneda de destino
     */
    public String getMonedaDestino() {
        return monedaDestino;
    }

    /**
     * Obtiene la tasa de cambio.
     *
     * @return la tasa de cambio
     */
    public double getTasa() {
        return tasa;
    }
}
