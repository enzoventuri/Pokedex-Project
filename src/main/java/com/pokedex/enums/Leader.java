package com.pokedex.enums;

public enum Leader {
    RED(0), BLUE(1), ASH(2), BROCK(3), MISTY(4);

    private int id;

    Leader(int id) {
        this.id = id;
    }

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
