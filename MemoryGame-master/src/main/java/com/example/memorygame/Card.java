package com.example.memorygame;

import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;

public class Card {
    private String suit;
    private String nomeAnimal;

    public Card(String suit, String nomeAnimal) {
        setSuit(suit);
        setnomeAnimal(nomeAnimal);
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getValidSuits()
    {
        return Arrays.asList("imagem");
    }

    /**
     * 
     * @param suit
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        if (getValidSuits().contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " inválido, precisa ser "+getValidSuits());
    }

    public String getnomeAnimal() {
        return nomeAnimal;
    }

    public static List<String> getValidnomeAnimal()
    {
        return Arrays.asList("arara","baleia","cobra","elefante","leao","macaco","ovelha","peixe","cachorro","vaca","tigre","hamster","gato", "foca");
    }

    /**
     * 
     * @param nomeAnimal
     */
    public void setnomeAnimal(String nomeAnimal) {
        nomeAnimal = nomeAnimal.toLowerCase();
        if (getValidnomeAnimal().contains(nomeAnimal))
            this.nomeAnimal = nomeAnimal;
        else
            throw new IllegalArgumentException(nomeAnimal + " é inválido, precisa ser de "+getnomeAnimal());
    }

    public String toString()
    {
        return nomeAnimal + " de " + suit;
    }

    public String getColour()
    {
        if (suit.equals("cachorro") || suit.equals("gato"))
            return "red";
        else
            return "black";
    }

    public int getValue()
    {
        return getValidnomeAnimal().indexOf(nomeAnimal) + 2;
    }

    /**
     * This method will return an Image that represents the Card
     */
    public Image getImage()
    {
        String pathName = "images/"+suit+nomeAnimal+".png";
        return new Image(Card.class.getResourceAsStream(pathName));
    }

    public Image getVersoCarta()
    {
        return new Image(Card.class.getResourceAsStream("images/interrogacao.png"));
    }
}
