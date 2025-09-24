package com.bovinemisconduct.belot.assetmanager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CardAsset {
    CLUBS_SEVEN("sevenClubs"),
    CLUBS_EIGHT("eightClubs"),
    CLUBS_NINE("nineClubs"),
    CLUBS_TEN("tenClubs"),
    CLUBS_JACK("jackClubs"),
    CLUBS_QUEEN("queenClubs"),
    CLUBS_KING("kingClubs"),
    CLUBS_ACE("aceClubs"),

    DIAMONDS_SEVEN("sevenDiamonds"),
    DIAMONDS_EIGHT("eightDiamonds"),
    DIAMONDS_NINE("nineDiamonds"),
    DIAMONDS_TEN("tenDiamonds"),
    DIAMONDS_JACK("jackDiamonds"),
    DIAMONDS_QUEEN("queenDiamonds"),
    DIAMONDS_KING("kingDiamonds"),
    DIAMONDS_ACE("aceDiamonds"),

    HEARTS_SEVEN("sevenHearts"),
    HEARTS_EIGHT("eightHearts"),
    HEARTS_NINE("nineHearts"),
    HEARTS_TEN("tenHearts"),
    HEARTS_JACK("jackHearts"),
    HEARTS_QUEEN("queenHearts"),
    HEARTS_KING("kingHearts"),
    HEARTS_ACE("aceHearts"),

    SPADES_SEVEN("sevenSpades"),
    SPADES_EIGHT("eightSpades"),
    SPADES_NINE("nineSpades"),
    SPADES_TEN("tenSpades"),
    SPADES_JACK("jackSpades"),
    SPADES_QUEEN("queenSpades"),
    SPADES_KING("kingSpades"),
    SPADES_ACE("aceSpades");

    @Getter
    private final String assetName;
}
