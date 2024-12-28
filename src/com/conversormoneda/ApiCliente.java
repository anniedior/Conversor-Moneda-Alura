package com.conversormoneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ApiCliente {
    private static final String API_KEY = "19a8039cd066da465a3cd877";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";
    private final HttpClient client;
    private final Gson gson;

    public ApiCliente() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double getTasaCambio(String fromCurrency, String toCurrency) {
        try {
            URI uri = new URI(API_URL + fromCurrency + "/" + toCurrency);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            TasaRespuesta tasarespuesta = gson.fromJson(response.body(), TasaRespuesta.class);
            return tasarespuesta.getConversionRate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
