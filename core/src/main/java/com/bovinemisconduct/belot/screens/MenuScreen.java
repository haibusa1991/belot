package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
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
public class MenuScreen implements Screen {
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

        Button startGameButton = new Button(2, 3, 2, 1, "Start Game", () -> {
            game.setScreen(GameScreen.class);
            dispose();
        });

        Button settingsButton = new Button(5, 3, 2, 1, "Setting", () -> {
            game.setScreen(SettingsScreen.class);
            dispose();
        });

        Button about = new Button(2, 1, 2, 1, "About", () -> {
            game.setScreen(AboutScreen.class);
            dispose();
        });

        Button exit = new Button(5, 1, 2, 1, "Exit", () -> {
            Gdx.app.exit();
            System.exit(0);
        });

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(startGameButton);
        inputMultiplexer.addProcessor(settingsButton);
        inputMultiplexer.addProcessor(about);
        inputMultiplexer.addProcessor(exit);

        Gdx.input.setInputProcessor(inputMultiplexer);

        spriteBatch.begin();

        debugText.draw();
        settingsButton.draw();
        startGameButton.draw();
        about.draw();
        exit.draw();

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
