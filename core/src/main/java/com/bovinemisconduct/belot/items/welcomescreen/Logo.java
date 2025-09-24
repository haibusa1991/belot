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
    private static final float sizeX = 600f;
    private static final float sizeY = 600f;

    private final Belot game;
    private final Sprite logo;
    private final Viewport viewport;
    private final float posX;
    private final float posY;

    public Logo(Belot game) {
        this.game = game;
        AssetManager assetmanager = game.getContextComponent(AssetManager.class);
        logo = new Sprite(assetmanager.get(Assets.LOGO, Texture.class));
        viewport = game.getContextComponent(FitViewport.class);

        posY = (viewport.getWorldHeight() - sizeY) / 2;
        posX = (viewport.getWorldWidth() - sizeX) / 2;

        logo.setSize(sizeX, sizeY);
        logo.setX(posX);
        logo.setY(posY);
    }

    public void draw() {
        logo.draw(game.getContextComponent(SpriteBatch.class));
    }
}