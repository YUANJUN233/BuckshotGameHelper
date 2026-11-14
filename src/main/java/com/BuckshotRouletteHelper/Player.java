package com.BuckshotRouletteHelper;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private final String id;
    private final String name;

    private final Map<Integer, BulletType> privateIntel = new HashMap<>();

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void markIntel(int slotIndex, BulletType type) {
        privateIntel.put(slotIndex, type);
    }

    public BulletType getIntel(int slotIndex) {
        return privateIntel.getOrDefault(slotIndex, BulletType.UNKNOWN);
    }

    public void clearIntel() {
        privateIntel.clear();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
