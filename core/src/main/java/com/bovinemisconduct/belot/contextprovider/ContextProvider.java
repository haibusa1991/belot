package com.bovinemisconduct.belot.contextprovider;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bovinemisconduct.belot.ui.fontsize.FontSizeProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
public class ContextProvider {
    private static ContextProvider instance;

    private final SpriteBatch spriteBatch = new SpriteBatch();
    private final FitViewport viewport = new FitViewport(800, 600);
    private final FontSizeProvider fontSizeProvider = new FontSizeProvider();

    public static ContextProvider getInstance() {
        if (instance == null) {
            instance = new ContextProvider();
        }

        return instance;
    }
}
