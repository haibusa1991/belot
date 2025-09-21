package com.bovinemisconduct.belot;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.bovinemisconduct.belot.screens.WelcomeScreen;

public class Belot extends Game {

    @Override
    public void create() {
        this.setScreen(new WelcomeScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public void setScreen(Class<? extends Screen> screen) {
        try {
            this.setScreen(screen.getDeclaredConstructor(Belot.class).newInstance(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
