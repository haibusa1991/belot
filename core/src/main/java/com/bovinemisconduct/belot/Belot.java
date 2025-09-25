package com.bovinemisconduct.belot;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.assetmanager.AssetManagerFactory;
import com.bovinemisconduct.belot.assetmanager.Assets;
import com.bovinemisconduct.belot.deckmanager.DeckManager;
import com.bovinemisconduct.belot.screens.BelotScreen;
import com.bovinemisconduct.belot.screens.WelcomeScreen;
import com.bovinemisconduct.belot.ui.fontsize.FontSizeProvider;

import java.util.HashMap;
import java.util.Map;

public class Belot extends Game {
    private Map<Class<?>, Object> context;

    @Override
    public void create() {
        populateContext();
        initViewport();
        setScreen(WelcomeScreen.class);
    }

    @Override
    public void render() {
        super.render();
    }

    private void populateContext() {
        context = new HashMap<>();

        context.put(SpriteBatch.class, new SpriteBatch());
        context.put(FitViewport.class, new FitViewport(800, 600)); //TODO: make configurable or move to some config class
        context.put(FontSizeProvider.class, new FontSizeProvider());
        context.put(AssetManager.class, AssetManagerFactory.getCompleteManager());
        context.put(Skin.class, new Skin(Gdx.files.internal(Assets.SKIN)));
        context.put(DeckManager.class, new DeckManager());
    }

    private void initViewport() {
        ScreenUtils.clear(Color.WHITE);
        FitViewport viewport = getContextComponent(FitViewport.class);
        viewport.apply();
    }

    public void setScreen(Class<? extends BelotScreen> screen) {
        try {
            this.setScreen(screen.getDeclaredConstructor(Belot.class).newInstance(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T getContextComponent(Class<? extends T> component) {
        Object contextComponent = context.get(component);
        if (contextComponent == null) {
            throw new IllegalArgumentException("No context element found for class: " + component.getName());
        }

        @SuppressWarnings("unchecked")
        T castComponent = (T) contextComponent;
        return castComponent;
    }
}
