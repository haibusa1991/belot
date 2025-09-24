package com.bovinemisconduct.belot.assetmanager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
@Builder(access = PRIVATE)
public class AssetManagerFactory {
    public static AssetManager getConfiguredManager() { // TODO: use when loading screen is implemented
        AssetManager assetManager = new AssetManager();

        assetManager.load(Assets.CARD_ATLAS, TextureAtlas.class);
        assetManager.load(Assets.LOGO, Texture.class);

        return assetManager;
    }

    public static AssetManager getCompleteManager() {
        AssetManager configuredManager = getConfiguredManager();
        configuredManager.finishLoading();
        return configuredManager;
    }
}
