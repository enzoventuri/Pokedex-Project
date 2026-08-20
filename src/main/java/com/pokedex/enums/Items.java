package com.pokedex.enums;

import com.pokedex.exceptions.ItemNotFound;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static ArrayList<Items> getAll(){

        ArrayList<Items> items = new ArrayList<>();

        items.addAll(Arrays.asList(Items.values()));

        return items;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
