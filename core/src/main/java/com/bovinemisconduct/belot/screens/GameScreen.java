package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.gamemaster.GameMaster;
import com.bovinemisconduct.belot.items.debug.DebugText;

public class GameScreen extends BelotScreen {
    private final DebugText debugText;
    private final Stage stage;
    private final GameMaster gameMaster;

    public GameScreen(Belot game) {
        super(game);
        this.gameMaster = game.getContextComponent(GameMaster.class);
        debugText = new DebugText(this);
        stage = new Stage(viewport, spriteBatch);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        gameMaster.dealCards(stage);

        TextButton backButton = new TextButton("Back", skin, "small");
        backButton.setPosition(10, 10);
        backButton.setSize(100, 50);
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

        debugText.draw(game);

        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        //not needed
    }

    @Override
    public void pause() {
        //not needed
    }

    @Override
    public void resume() {
        //not needed
    }

    @Override
    public void hide() {
        //not needed
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
