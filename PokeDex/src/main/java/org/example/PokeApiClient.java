package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.net.HttpURLConnection;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;


public class PokeApiClient {
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/pikachu"; // URL to fetch Pikachu data
    private OkHttpClient client;
    private Gson gson;
    private HttpClient client1;

    public PokeApiClient() {
        //client = new OkHttpClient();
        HttpClient client1 = HttpClient.newHttpClient();
        gson = new Gson();
    }
    //if (rumore= true){notadisciplinarefacile=true;}

    // Method to fetch Pikachu data from the PokeAPI
    public PokemonData fetchPikachuData() throws IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/ability/1/"))
                .build();
        /*Request request = new Request.Builder()
                .url(API_URL)
                .build();
        */

        /*
        try (HttpResponse<T> response = client1.sendAsync(request, HttpResponse.BodyHandlers.ofString())) {
            if(client1.isTerminated()){
                throw new IOException("Unexpected code " + response);
            }
        }
         */
        try (client1.send(request, HttpResponse.BodyHandlers.ofString())
                     //.thenApply(HttpResponse::body)
                     //.thenAccept(System.out::println)
                     //.join();
        ) {
            if(client1.isTerminated()){
                throw new IOException("Unexpected code " + response);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        */
            // Parse the JSON response into a PokemonData object
            /*
            String jsonResponse = response.body().string();
            return gson.fromJson(jsonResponse, PokemonData.class);
            */
            String jsonResponse = client1.toString();
            return gson.fromJson(jsonResponse, PokemonData.class);

        }
}

