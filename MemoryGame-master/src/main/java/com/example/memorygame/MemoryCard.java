package com.example.memorygame;

public class MemoryCard extends Card{
    private boolean matched;

    public MemoryCard(String suit, String nomegetnomeAnimal) {
        super(suit, nomegetnomeAnimal);
        this.matched = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * This method returns true if the 2 MemoryCard objects
     * have the same suit and nomeAnimal
     */
    public boolean isSameCard(MemoryCard otherCard)
    {
        return (this.getSuit().equals(otherCard.getSuit()) &&
                (this.getnomeAnimal().equals(otherCard.getnomeAnimal())));
    }
}
