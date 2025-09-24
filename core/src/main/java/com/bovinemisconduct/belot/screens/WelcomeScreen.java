package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.items.debug.DebugText;
import com.bovinemisconduct.belot.items.welcomescreen.Logo;

public class WelcomeScreen extends BelotScreen {
    private final Logo logo;
    private final DebugText debugText;


    public WelcomeScreen(Belot game) {
        super(game);

        logo = new Logo(game);
        debugText = new DebugText(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        spriteBatch.begin();

        logo.draw();
        debugText.draw(game);

        spriteBatch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(MenuScreen.class);
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
    }
}
