package com.bovinemisconduct.belot.deckmanager;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class DeckCard {
    private final String cardSpriteName;
    private final CardSuit cardSuit;
    private final CardRank cardRank;

    @Override
    public String toString() {
        String suit = switch (cardSuit) {
            case CLUBS -> "♣";
            case DIAMONDS -> "♦";
            case HEARTS -> "♥";
            case SPADES -> "♠";
        };

        String rank = switch (cardRank) {
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
            case TEN -> "10";
            case JACK -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            case ACE -> "A";
        };

        return String.format("%s%s - %s", rank, suit, cardSpriteName);
    }
}
