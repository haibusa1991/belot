package com.bovinemisconduct.belot.items.welcomescreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;
import lombok.Getter;

@Getter
public class Logo extends Sprite {
    private static final Sprite logo = new Sprite(new Texture("logo.png"));
    private static final Viewport viewport = ContextProvider.getInstance().getViewport();
    private static final float sizeX = 600f;
    private static final float sizeY = 600f;
    private static final float posX = (viewport.getWorldWidth() - sizeX) / 2;
    private static final float posY = (viewport.getWorldHeight() - sizeY) / 2;

    public Logo() {
        logo.setSize(sizeX, sizeY);
        logo.setX(posX);
        logo.setY(posY);
    }

    public void draw() {
        logo.draw(ContextProvider.getInstance().getSpriteBatch());
    }

}