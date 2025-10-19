package com.bovinemisconduct.belot.gamemaster;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.assetmanager.Assets;
import com.bovinemisconduct.belot.assetmanager.CardAssets;
import com.bovinemisconduct.belot.deckmanager.CardConstants;
import com.bovinemisconduct.belot.deckmanager.DeckCard;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GameMaster {

    private final Belot game;

    List<DeckCard> rightPlayerCards;
    List<DeckCard> topPlayerCards;
    List<DeckCard> leftPlayerCards;
    List<DeckCard> bottomPlayerCards;

    public void dealCards(Stage stage) {
        //place deck in the center of the stage
        AssetManager assetManager = game.getContextComponent(AssetManager.class);
        TextureAtlas atlas = assetManager.get(Assets.CARD_ATLAS, TextureAtlas.class);
        TextureAtlas.AtlasRegion cardBack = atlas.findRegion(CardAssets.CARD_BACK_ASSET_NAME);
        cardBack.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        Image image = new Image(cardBack);
        Vector2 vector2 = centerDeck(stage);
        image.setSize(CardConstants.CARD_WIDTH, CardConstants.CARD_HEIGHT);
        image.setPosition(vector2.x, vector2.y);
        stage.addActor(image);

        //animate dealing cards to players
    }

    private Vector2 centerDeck(Stage stage) {
        float screenWidth = stage.getWidth();
        float screenHeight =stage.getHeight();

        float centerX = (screenWidth - CardConstants.CARD_WIDTH) / 2f;
        float centerY = (screenHeight - CardConstants.CARD_HEIGHT) / 2f;
        return new Vector2(centerX, centerY);
    }
}
