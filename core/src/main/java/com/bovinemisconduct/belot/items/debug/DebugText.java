package com.bovinemisconduct.belot.items.debug;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;
import com.bovinemisconduct.belot.screens.BelotScreen;
import com.bovinemisconduct.belot.ui.fontsize.UiFontSize;

public class DebugText extends BitmapFont {
    private final float posX;
    private final float posY;

    private final BitmapFont font = new BitmapFont();

    private final Screen screen;

    public DebugText(BelotScreen screen) {
        this.screen = screen;
        font.setUseIntegerPositions(false);
        font.setColor(Color.RED);
        //TODO move font instancing to provider. Also provide higher quality font
        float fontSize = ContextProvider.getInstance().getFontSizeProvider().getFontSize(UiFontSize.MEDIUM);
        font.getData().setScale(fontSize);

        posX = 25f;
        posY = screen.getViewport().getWorldHeight()-25f;
    }

    public void draw() {
        SpriteBatch spriteBatch = ContextProvider.getInstance().getSpriteBatch();
        String screenName = screen.getClass().getSimpleName();

        font.draw(spriteBatch, screenName, posX, posY);
    }
}
