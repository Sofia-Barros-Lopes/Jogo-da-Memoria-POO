package com.example.memorygame;

public class Combinacao extends Carta{
    private boolean combinou;

    public Combinacao(String suit, String nomeAnimal) {
        super(suit, nomeAnimal);
        this.combinou = false;
    }

    public boolean combinou() {
        return combinou;
    }

    public void setCombinou(boolean combinou) {
        this.combinou = combinou;
    }

    public boolean mesmaCarta(Combinacao otherCarta)
    {
        return (this.getSuit().equals(otherCarta.getSuit()) &&
                (this.getnomeAnimal().equals(otherCarta.getnomeAnimal())));
    }
}
