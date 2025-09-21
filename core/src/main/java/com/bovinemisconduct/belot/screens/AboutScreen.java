package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;
import com.bovinemisconduct.belot.items.common.Button;
import com.bovinemisconduct.belot.items.debug.DebugText;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AboutScreen implements Screen {
    private final SpriteBatch spriteBatch = ContextProvider.getInstance().getSpriteBatch();
    private final FitViewport viewport = ContextProvider.getInstance().getViewport();
    private final Belot game;

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        DebugText debugText = new DebugText(this);

        Button menuButton = new Button(0, 0, 2, 1, "Menu", () -> {
            game.setScreen(MenuScreen.class);
            dispose();
        });

        Gdx.input.setInputProcessor(menuButton);

        spriteBatch.begin();

        debugText.draw();
        menuButton.draw();

        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

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
