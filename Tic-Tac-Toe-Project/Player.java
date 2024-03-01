/*
 * Created on 2024-02-18
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

 public class Player {
    private String name;
    private char symbol;

    // Constructor for Player objects
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

}
