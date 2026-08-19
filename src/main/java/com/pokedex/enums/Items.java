package com.pokedex.enums;

import com.pokedex.exceptions.ItemNotFound;

public enum Items {
    BALL, MEDICINE, EVOLUTION_STONE, BERRY, TM_HM, TREASURE;

    public static Items getItemFromName(String name) {
        for (Items i : Items.values()) {
            if (i.toString().equalsIgnoreCase(name)) {
                return i;
            }
        }

        throw new ItemNotFound("Could not find Item");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
