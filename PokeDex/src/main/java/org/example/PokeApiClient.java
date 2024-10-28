package org.example;

import com.google.gson.Gson;
/*
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
*/

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

//while restructuring this class to use java httpclient i should have focused more on what
//each method does, so that i could organize the code better, and by result have the code more readable
public class PokeApiClient {
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/pikachu"; // URL to fetch Pikachu data
    //private OkHttpClient client;
    private Gson gson;
    private HttpClient client;

    public PokeApiClient() {
        //client = new OkHttpClient();
        HttpClient client = HttpClient.newHttpClient();
        gson = new Gson();
    }
    //if (rumore = true){notadisciplinarefacile=true;}

    public PokemonData fetchPikachuData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Unexpected response code: " + response.statusCode());
        }

        String jsonResponse = response.body();
        return gson.fromJson(jsonResponse, PokemonData.class);
    }

    // Method to fetch Pikachu data from the PokeAPI
    public PokemonData RubenfetchPikachuData() throws IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/ability/1/"))
                .build();
        /*Request request = new Request.Builder()
                .url(API_URL)
                .build();
        */

        /*
        try (HttpResponse<T> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())) {
            if(client1.isTerminated()){
                throw new IOException("Unexpected code " + response);
            }
        }
         */
        try (client.send(request, HttpResponse.BodyHandlers.ofString())
                     //.thenApply(HttpResponse::body)
                     //.thenAccept(System.out::println)
                     //.join();
        ) {
            if(client.isTerminated()){
                throw new IOException("Unexpected code " + client.response);
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
            String jsonResponse = client.toString();
            return gson.fromJson(jsonResponse, PokemonData.class);

        }
}

