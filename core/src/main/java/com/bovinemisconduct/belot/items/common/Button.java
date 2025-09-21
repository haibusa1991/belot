package com.bovinemisconduct.belot.items.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;
import com.bovinemisconduct.belot.ui.fontsize.UiFontSize;
import lombok.RequiredArgsConstructor;

import java.awt.*;

@RequiredArgsConstructor
public class Button implements InputProcessor {
    private static final Color green = new Color(0.18f, 0.7f, 0.27f, 1f);
    private static final Color lightGreen = new Color(0.92f, 0.85f, 0.33f, 1f);
    private static final Color darkGreen = new Color(0.12f, 0.55f, 0.92f, 1f);

    private final int posX, posY, width, height;
    private final String buttonText;
    private final Runnable onClick;

    private final Texture normalTexture = createTexture(green);
    private final Texture hoverTexture = createTexture(lightGreen);
    private final Texture pressedTexture = createTexture(darkGreen);

    private Texture createTexture(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();

        Texture texture = new Texture(pixmap);

        pixmap.dispose();

        return texture;
    }

    public void draw() {
        Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        ContextProvider.getInstance().getViewport().unproject(touch);
        float mouseX = touch.x;
        float mouseY = touch.y;

        Rectangle bounds = new Rectangle(posX, posY, width, height);
        boolean isHovered = bounds.contains(mouseX, mouseY);

        Texture finalTexture = normalTexture;

        if (isHovered) {
            finalTexture = hoverTexture;
        }

        SpriteBatch spriteBatch = ContextProvider.getInstance().getSpriteBatch();
        spriteBatch.draw(finalTexture, posX, posY, width, height);

        // Draw centered text
        BitmapFont font = new BitmapFont();
        font.setUseIntegerPositions(false);
        font.setColor(Color.WHITE);
        //TODO move font instancing to provider. Also provide higher quality font
        float fontSize = ContextProvider.getInstance().getFontSizeProvider().getFontSize(UiFontSize.MEDIUM);
        font.getData().setScale(fontSize);


        GlyphLayout layout = new GlyphLayout(font, buttonText);
        float textX = posX + (width - layout.width) / 2f;
        float textY = posY + (height + layout.height) / 2f; // y is baseline
        font.draw(spriteBatch, layout, textX, textY);
        font.draw(spriteBatch, buttonText, textX, textY);
    }

    public void dispose() {
        normalTexture.dispose();
        hoverTexture.dispose();
        pressedTexture.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) {
            return false;
        }

        Vector2 touch = new Vector2(screenX, screenY);
        ContextProvider.getInstance().getViewport().unproject(touch);

        Rectangle bounds = new Rectangle(posX, posY, width, height);

        return bounds.contains(touch.x, touch.y);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) {
            return false;
        }

        Vector2 touch = new Vector2(screenX, screenY);
        ContextProvider.getInstance().getViewport().unproject(touch);

        Rectangle bounds = new Rectangle(posX, posY, width, height);
        boolean isHovered = bounds.contains(touch.x, touch.y);

        if (isHovered) {
            onClick.run();
            return true;
        }

        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
