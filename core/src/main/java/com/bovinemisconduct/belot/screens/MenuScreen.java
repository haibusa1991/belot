package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.items.debug.DebugText;

public class MenuScreen extends BelotScreen {
    private final Stage stage;
    private final Table table;
    private final DebugText debugText;

    public MenuScreen(Belot game) {
        super(game);
        stage = new Stage(viewport, spriteBatch);
        table = new Table();
        debugText = new DebugText(this);

        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        stage.addActor(table);

    }

    @Override
    public void show() {
        addNewGameButton(table, skin);
        addSettingsButton(table, skin);
        addAboutButton(table, skin);
        addExitButton(table, skin);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);
        stage.act(delta);
        stage.draw();

        spriteBatch.begin();

        debugText.draw(game);

        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

    private void addNewGameButton(Table table, Skin skin) {
        TextButton newGameButton = new TextButton("New game", skin, "small");
        table.row().pad(10, 10, 10, 10);
        table.add(newGameButton).size(200, 50);

        newGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(GameScreen.class);
            }
        });
    }

    private void addSettingsButton(Table table, Skin skin) {
        TextButton settingsButton = new TextButton("Settings", skin, "small");
        table.row().pad(10, 10, 10, 10);
        table.add(settingsButton).size(200, 50);

        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(SettingsScreen.class);
            }
        });
    }

    private void addAboutButton(Table table, Skin skin) {
        TextButton aboutButton = new TextButton("About", skin, "small");
        table.row().pad(10, 10, 10, 10);
        table.add(aboutButton).size(200, 50);

        aboutButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AboutScreen.class);
            }
        });
    }

    private void addExitButton(Table table, Skin skin) {
        TextButton exitButton = new TextButton("Exit", skin, "small");
        table.row().pad(10, 10, 10, 10);
        table.add(exitButton).size(200, 50);

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
    }
}
