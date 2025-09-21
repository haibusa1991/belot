package com.bovinemisconduct.belot.ui.fontsize;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UiFontSize {
    TINY(1),
    SMALL(1.5f),
    MEDIUM(2),
    LARGE(3),
    HUGE(5);

    @Getter
    private final float scaleFactor;
}
