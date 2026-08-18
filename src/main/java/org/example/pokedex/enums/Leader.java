package org.example.pokedex.enums;

public enum Leader {
    MIGUEL, ODRAUDE_TREFFEG, OZNE_IRUTNEV;

    public static Leader getLeaderFromName(String name) {
        for (Leader l : Leader.values()) {
            if (l.toString().equalsIgnoreCase(name)) {
                return l;
            }
        }

        throw new RuntimeException("Could not find Leader");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
