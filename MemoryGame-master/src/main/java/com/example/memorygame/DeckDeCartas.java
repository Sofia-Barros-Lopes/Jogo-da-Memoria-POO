package com.example.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckDeCartas {
    private ArrayList<Carta> deck;

    public DeckDeCartas() {
        this.deck = new ArrayList<>();
        List<String> suits = Carta.getValidSuits();
        List<String> nomeAnimal = Carta.getValidnomeAnimal();

        for (String suit : suits)
        {
            for (String faceName : nomeAnimal)
            {
                deck.add(new Carta(suit,faceName));
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public Carta dealTopCarta()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    public int getNumOfCartas()
    {
        return deck.size();
    }
}
