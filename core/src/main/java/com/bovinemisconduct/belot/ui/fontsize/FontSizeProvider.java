package com.bovinemisconduct.belot.ui.fontsize;

import com.badlogic.gdx.Gdx;
import com.bovinemisconduct.belot.contextprovider.ContextProvider;

public class FontSizeProvider {

    public float getFontSize(UiFontSize uiFontSize) {
        float baseline = ContextProvider.getInstance().getViewport().getWorldHeight() / Gdx.graphics.getHeight();
        return baseline * uiFontSize.getScaleFactor();
    }
}
