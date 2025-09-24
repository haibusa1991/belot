package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bovinemisconduct.belot.Belot;
//import com.bovinemisconduct.belot.items.common.Button;
import com.bovinemisconduct.belot.items.debug.DebugText;

public class AboutScreen extends BelotScreen {
    private final Stage stage;
    private final Skin skin;
    private final DebugText debugText;

    public AboutScreen(Belot game) {
        super(game);

        debugText = new DebugText(this);
        stage = new Stage(viewport, spriteBatch);
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        TextButton backButton = new TextButton("Back", skin, "small");
        backButton.setPosition(10,10);
        stage.addActor(backButton);

        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(MenuScreen.class);
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        viewport.apply();
        stage.act();
        stage.draw();

        spriteBatch.begin();

        debugText.draw();

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
        stage.dispose();
    }
}
