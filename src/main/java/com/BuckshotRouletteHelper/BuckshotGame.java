package com.BuckshotRouletteHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class BuckshotGame {
    private final List<BulletType> slots = new ArrayList<>();
    private int currentSlotIndex = 0;

    private int remainingLive = 0;
    private int remainingBlank = 0;

    private boolean isSawedOff = false;
    private boolean isCurrentInverted = false;

    private final Map<String, Player> players = new HashMap<>();

    public Player getOrCreatePlayer(String userId, String userName) {
        return players.computeIfAbsent(userId, id -> new Player(id, userName));
    }

    public void reload(int liveCount, int blankCount) {
        this.remainingLive = liveCount;
        this.remainingBlank = blankCount;
        this.currentSlotIndex = 0;
        this.isSawedOff = false;
        this.isCurrentInverted =false;
        this.slots.clear();
        int total = liveCount + blankCount;
        for (int i = 0; i < total; i++) {
            slots.add(BulletType.UNKNOWN);
        }
        for (Player player : players.values()) {
            player.clearIntel();
        }
    }

    // Status Getters
    public boolean isChamberEmpty() {
        return currentSlotIndex >= slots.size();
    }

    public int getRemainingTotal() {
        return remainingBlank + remainingLive;
    }

    public int getRemainingLive() {
        return remainingLive;
    }

    public int getRemainingBlank() {
        return remainingBlank;
    }

    public int getCurrentSlotIndex() {
        return currentSlotIndex;
    }

    public boolean isSawedOff() {
        return isSawedOff;
    }

    public boolean isCurrentInverted() {
        return isCurrentInverted;
    }

    // Shoot Func
    public void shoot(boolean isLive) {
        if (isChamberEmpty()) {
            return;
        }

        slots.set(currentSlotIndex, isLive ? BulletType.LIVE : BulletType.BLANK);
    }
}
