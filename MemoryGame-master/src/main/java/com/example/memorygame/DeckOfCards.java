package com.example.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        List<String> suits = Card.getValidSuits();
        List<String> nomeAnimal = Card.getValidnomeAnimal();

        for (String suit : suits)
        {
            for (String faceName : nomeAnimal)
            {
                deck.add(new Card(suit,faceName));
            }
        }
    }

    /**
     * This method will shuffle the card objects
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * This method will return the top card from the deck.
     * If the deck is empty, it will return null
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    public int getNumOfCards()
    {
        return deck.size();
    }
}
