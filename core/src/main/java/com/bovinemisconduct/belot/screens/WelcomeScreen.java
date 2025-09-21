package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;
import com.bovinemisconduct.belot.items.debug.DebugText;
import com.bovinemisconduct.belot.items.welcomescreen.Logo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WelcomeScreen implements Screen {
    private final Belot game;
    private final SpriteBatch spriteBatch = ContextProvider.getInstance().getSpriteBatch();
    private final FitViewport viewport = ContextProvider.getInstance().getViewport();

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        Logo logo = new Logo();
        DebugText debugText = new DebugText(this);

        spriteBatch.begin();

        logo.draw();
        debugText.draw();

        spriteBatch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(MenuScreen.class);
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
    }
}
