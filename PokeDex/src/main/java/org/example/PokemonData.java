package org.example;

public class PokemonData {
    private String name;
    private int height;
    private int weight;

    // Add more fields as necessary based on the JSON structure

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() { return "Pokemon: " + name + ", Height: " + height + ", Weight: " + weight; }
}
