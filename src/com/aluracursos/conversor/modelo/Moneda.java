package com.aluracursos.conversor.modelo;

/**
 * Representa una moneda con un código y un nombre.
 */
public class Moneda {
    private final String codigo; // Código de la moneda (ej. USD, ARS, BRL, COP)
    private final String nombre; // Nombre de la moneda (ej. Dólar, Peso Argentino)

    /**
     * Crea una nueva instancia de Moneda.
     *
     * @param codigo el código de la moneda
     * @param nombre el nombre de la moneda
     * @throws IllegalArgumentException si el código o el nombre son nulos o vacíos
     */
    public Moneda(String codigo, String nombre) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda no puede ser nulo o vacío");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la moneda no puede ser nulo o vacío");
        }
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * Obtiene el código de la moneda.
     *
     * @return el código de la moneda
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre de la moneda.
     *
     * @return el nombre de la moneda
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
