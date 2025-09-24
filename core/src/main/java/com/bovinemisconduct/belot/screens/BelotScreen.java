package com.bovinemisconduct.belot.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.Belot;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class BelotScreen implements Screen {
    protected final Belot game;
    protected final SpriteBatch spriteBatch = ContextProvider.getInstance().getSpriteBatch();
    protected final FitViewport viewport = ContextProvider.getInstance().getViewport();
}
