package com.bovinemisconduct.belot.assetmanager;

import com.bovinemisconduct.belot.deckmanager.CardRank;
import com.bovinemisconduct.belot.deckmanager.CardSuit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardAssets {
    @Getter
    public static final String CARD_BACK_ASSET_NAME = "cardBack";

    private static final Map<CardSuit, Map<CardRank, String>> assetNames = populateCardAssets();

    private static Map<CardSuit, Map<CardRank, String>> populateCardAssets() {
        Map<CardSuit, Map<CardRank, String>> assets = new EnumMap<>(CardSuit.class);

        EnumMap<CardRank, String> clubs = new EnumMap<>(CardRank.class);
        clubs.put(CardRank.SEVEN, "sevenClubs");
        clubs.put(CardRank.EIGHT, "eightClubs");
        clubs.put(CardRank.NINE, "nineClubs");
        clubs.put(CardRank.TEN, "tenClubs");
        clubs.put(CardRank.JACK, "jackClubs");
        clubs.put(CardRank.QUEEN, "queenClubs");
        clubs.put(CardRank.KING, "kingClubs");
        clubs.put(CardRank.ACE, "aceClubs");
        assets.put(CardSuit.CLUBS, clubs);

        EnumMap<CardRank, String> diamonds = new EnumMap<>(CardRank.class);
        diamonds.put(CardRank.SEVEN, "sevenDiamonds");
        diamonds.put(CardRank.EIGHT, "eightDiamonds");
        diamonds.put(CardRank.NINE, "nineDiamonds");
        diamonds.put(CardRank.TEN, "tenDiamonds");
        diamonds.put(CardRank.JACK, "jackDiamonds");
        diamonds.put(CardRank.QUEEN, "queenDiamonds");
        diamonds.put(CardRank.KING, "kingDiamonds");
        diamonds.put(CardRank.ACE, "aceDiamonds");
        assets.put(CardSuit.DIAMONDS, diamonds);

        EnumMap<CardRank, String> hearts = new EnumMap<>(CardRank.class);
        hearts.put(CardRank.SEVEN, "sevenHearts");
        hearts.put(CardRank.EIGHT, "eightHearts");
        hearts.put(CardRank.NINE, "nineHearts");
        hearts.put(CardRank.TEN, "tenHearts");
        hearts.put(CardRank.JACK, "jackHearts");
        hearts.put(CardRank.QUEEN, "queenHearts");
        hearts.put(CardRank.KING, "kingHearts");
        hearts.put(CardRank.ACE, "aceHearts");
        assets.put(CardSuit.HEARTS, hearts);

        EnumMap<CardRank, String> spades = new EnumMap<>(CardRank.class);
        spades.put(CardRank.SEVEN, "sevenSpades");
        spades.put(CardRank.EIGHT, "eightSpades");
        spades.put(CardRank.NINE, "nineSpades");
        spades.put(CardRank.TEN, "tenSpades");
        spades.put(CardRank.JACK, "jackSpades");
        spades.put(CardRank.QUEEN, "queenSpades");
        spades.put(CardRank.KING, "kingSpades");
        spades.put(CardRank.ACE, "aceSpades");
        assets.put(CardSuit.SPADES, spades);

        return assets;
    }

    public static String getAssetName(CardSuit suit, CardRank rank) {
        return assetNames.get(suit).get(rank);
    }
}
