package com.aluracursos.conversor.servicio;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servicio para obtener tasas de cambio desde una API.
 */
public class ApiServicio {

    private static final String API_URL_BASE = "https://v6.exchangerate-api.com/v6/2ae4ba1dc57693755ddde355/latest/";

    /**
     * Obtiene las tasas de cambio desde la API para una moneda base específica.
     *
     * @param monedaBase el código de la moneda base
     * @return un objeto JSON con las tasas de cambio, o null si ocurre un error
     */
    public JsonObject obtenerTasasDeCambio(String monedaBase) {
        String urlStr = API_URL_BASE + monedaBase;

        try {
            // Hacer la solicitud HTTP a la API
            URL url = new URL(urlStr);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.connect();

            // Convertir la respuesta a JSON
            try (InputStreamReader reader = new InputStreamReader((InputStream) conexion.getContent())) {
                JsonParser parserJson = new JsonParser();
                JsonElement raiz = parserJson.parse(reader);
                JsonObject objetoJson = raiz.getAsJsonObject();

                // Verificar si la solicitud fue exitosa
                String resultadoSolicitud = objetoJson.get("result").getAsString();
                if ("success".equals(resultadoSolicitud)) {
                    // Retornar el objeto JSON completo
                    return objetoJson;
                } else {
                    System.out.println("Error en la solicitud a la API.");
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }
}
