package com.bovinemisconduct.belot;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;
import com.bovinemisconduct.belot.screens.BelotScreen;
import com.bovinemisconduct.belot.screens.WelcomeScreen;

public class Belot extends Game {

    @Override
    public void create() {
        initViewport();
        setScreen(WelcomeScreen.class);
    }

    @Override
    public void render() {
        super.render();
    }

    private void initViewport() {
        ScreenUtils.clear(Color.WHITE);
        FitViewport viewport = ContextProvider.getInstance().getViewport();
        viewport.apply();
    }

    public void setScreen(Class<? extends BelotScreen> screen) {
        try {
            this.setScreen(screen.getDeclaredConstructor(Belot.class).newInstance(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
