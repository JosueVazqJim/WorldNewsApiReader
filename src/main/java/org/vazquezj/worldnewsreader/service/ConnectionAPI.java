package org.vazquezj.worldnewsreader.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class ConnectionAPI {
    private static final String URL = "https://api.worldnewsapi.com/";
    private static final String API = "YOUR-API-KEY";
    private static final String limit = "5";
    private HttpClient client;

    public ConnectionAPI() {
        this.client = HttpClient.newHttpClient();
    }

    // Método para obtener noticias con palabras clave
    public String getNewsByKeyWords(String keywords, String country, String language, String date) {
        // Se crea un mapa con los parámetros necesarios para este endpoint
        Map<String, String> params = Map.of(
                "text", keywords,
                "source-countries", country,
                "language", language,
                "from", date,
                "number", limit
        );
        String endpoint = buildEndpoint("search-news", params);
        return sendRequest(endpoint);
    }

    public String topNews(String country, String languaje) {
        Map<String, String> params = Map.of(
                "source-country", country,
                "language", languaje
        );
        String endpoint = buildEndpoint("top-news", params);
        return sendRequest(endpoint);
    }

    public String searchByID(String id) {
        Map<String, String> params = Map.of(
                "ids", id
        );
        String endpoint = buildEndpoint("retrieve-news", params);
        return sendRequest(endpoint);
    }

    public String searchByCategory(String category, String country, String date) {
        Map<String, String> params = Map.of(
                "categories", category,
                "source-countries", country,
                "earliest-publish-date", date,
                "language", "en"
        );
        String endpoint = buildEndpoint("search-news", params);
        return sendRequest(endpoint);
    }

    // Método para construir el endpoint a partir de un mapa de parámetros
    private String buildEndpoint(String path, Map<String, String> params) {
        // Codificamos todos los valores y los agregamos a la URL
        String paramString = params.entrySet().stream()
                .map(entry -> encodeValue(entry.getKey()) + "=" + encodeValue(entry.getValue()))
                .collect(Collectors.joining("&"));

        //con el entrySet() obtenemos un Set de cada elemento del mapa original. con el, los registros del Set
        //seran de tipo Map.Entry<K,V>, no son Maps como tal, sino que son pares de clave y valor
        //con el Collectors.joining("&") se unen los elementos del stream con el caracter "&"

        return path + "?" + paramString;
    }

    // Método privado para codificar valores de los parámetros
    private String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error al codificar el valor: " + value, e);
        }
    }

    // Método privado para realizar la solicitud HTTP y manejar la respuesta
    private String sendRequest(String endpoint) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + endpoint + "&api-key=" + API))
                .build();

        HttpResponse<String> response;
        System.out.println("Request URI: " + request.uri());

        try {
            response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al enviar la solicitud HTTP", e);
        }

        return response.body();
    }
}
