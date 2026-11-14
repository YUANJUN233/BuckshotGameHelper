package com.BuckshotRouletteHelper;

public enum BulletType {
    UNKNOWN,
    LIVE,
    BLANK;

    public BulletType invert() {
        return switch (this) {
            case LIVE -> BLANK;
            case BLANK -> LIVE;
            case UNKNOWN -> UNKNOWN;
        };
    }
}
