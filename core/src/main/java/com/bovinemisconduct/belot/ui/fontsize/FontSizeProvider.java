package com.bovinemisconduct.belot.ui.fontsize;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FontSizeProvider {

    public float getFontSize(UiFontSize uiFontSize, Viewport viewport) {
        float baseline = viewport.getWorldHeight() / Gdx.graphics.getHeight();
        return baseline * uiFontSize.getScaleFactor();
    }
}
