package com.bovinemisconduct.belot.items.welcomescreen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.assetmanager.Assets;
import lombok.Getter;

@Getter
public class Logo extends Sprite {
    private static final float SIZE_X = 600f;
    private static final float SIZE_Y = 600f;

    private final Belot game;
    private final Sprite logoSprite;
    private final Viewport viewport;
    private final float posX;
    private final float posY;

    public Logo(Belot game) {
        this.game = game;
        AssetManager assetmanager = game.getContextComponent(AssetManager.class);
        logoSprite = new Sprite(assetmanager.get(Assets.LOGO, Texture.class));
        viewport = game.getContextComponent(FitViewport.class);

        posY = (viewport.getWorldHeight() - SIZE_Y) / 2;
        posX = (viewport.getWorldWidth() - SIZE_X) / 2;

        logoSprite.setSize(SIZE_X, SIZE_Y);
        logoSprite.setX(posX);
        logoSprite.setY(posY);
    }

    public void draw() {
        logoSprite.draw(game.getContextComponent(SpriteBatch.class));
    }
}