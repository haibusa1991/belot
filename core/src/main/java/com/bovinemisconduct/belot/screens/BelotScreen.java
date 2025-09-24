package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.Belot;
import lombok.Getter;

@Getter
public abstract class BelotScreen implements Screen {
    public final Belot game; //TODO: make protected once DebugText is updated
    protected final SpriteBatch spriteBatch;
    protected final FitViewport viewport;
    protected final Skin skin;

    public BelotScreen(Belot game) {
        this.game = game;

        spriteBatch = game.getContextComponent(SpriteBatch.class);
        viewport = game.getContextComponent(FitViewport.class);
        skin = game.getContextComponent(Skin.class);
    }
}
