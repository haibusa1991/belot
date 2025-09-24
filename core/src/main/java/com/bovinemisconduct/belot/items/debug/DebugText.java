package com.bovinemisconduct.belot.items.debug;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.screens.BelotScreen;
import com.bovinemisconduct.belot.ui.fontsize.FontSizeProvider;
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
        FontSizeProvider fontSizeProvider = screen.getGame().getContextComponent(FontSizeProvider.class);
        Viewport viewport = screen.getGame().getContextComponent(FitViewport.class);
        float fontSize = fontSizeProvider.getFontSize(UiFontSize.MEDIUM, viewport);
        font.getData().setScale(fontSize);

        posX = 25f;
        posY = screen.getViewport().getWorldHeight() - 25f;
    }

    public void draw(Belot game) {
        SpriteBatch spriteBatch = game.getContextComponent(SpriteBatch.class);
        String screenName = screen.getClass().getSimpleName();

        font.draw(spriteBatch, screenName, posX, posY);
    }
}
