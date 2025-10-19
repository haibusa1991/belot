package com.bovinemisconduct.belot.deckmanager;

import com.bovinemisconduct.belot.assetmanager.CardAssets;

import java.util.*;

public class DeckManager {
    private static final int MIN_CUT_SIZE = 5;
    private static final int MAX_CUT_SIZE = 27;

    private final LinkedList<DeckCard> deck = new LinkedList<>();
    private final Random random = new Random();

    public DeckManager() {
        populateDeck();
    }

    private void populateDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {

                DeckCard card = DeckCard
                        .builder()
                        .cardSuit(suit)
                        .cardRank(rank)
                        .cardSpriteName(CardAssets.getAssetName(suit, rank))
                        .build();

                deck.add(card);
            }
        }
    }

    public List<DeckCard> getDeck() {
        return Collections.unmodifiableList(deck);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void cutDeck() {
        int cutSize = random.nextInt(MAX_CUT_SIZE - MIN_CUT_SIZE) + MIN_CUT_SIZE;

        for (int i = 0; i < cutSize; i++) {
            deck.addLast(deck.removeFirst());
        }
    }

    public void reorderDeck(List<DeckCard> orderedDeck) {
        deck.clear();
        deck.addAll(orderedDeck);
    }

    public List<DeckCard> dealFirstStageForPlayer(int playerOrder) {
        int[][] cardIndices = {
                {0, 1, 8, 9, 10},
                {2, 3, 11, 12, 13},
                {4, 5, 14, 15, 16},
                {6, 7, 17, 18, 19}
        };

        return dealCards(cardIndices[playerOrder]);
    }

    public List<DeckCard> dealSecondStageForPlayer(int playerOrder) {
        int[][] cardIndices = {
                {20, 21, 22},
                {23, 24, 25},
                {26, 27, 28},
                {29, 30, 31}
        };

        return dealCards(cardIndices[playerOrder]);
    }

    private List<DeckCard> dealCards(int[] cardIndices) {
        return Arrays.stream(cardIndices)
                .mapToObj(deck::get)
                .toList();
    }
}
