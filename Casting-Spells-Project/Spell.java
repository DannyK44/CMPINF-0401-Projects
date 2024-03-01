/*
 * Created on Wed Jan 31 2024
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Random;

class Spell {
   static Random random = new Random(System.currentTimeMillis());

    private String name;
    private int impact;

    // Spell constructor, taking just one parameter- name
    public Spell(String name) {
        this.name = name;
        this.impact = Spell.generateImpact();
    }
    public static int generateImpact() {
        int impact = random.nextInt(10) + 1;
        return impact;
    }

    public int getImpact() {
        return impact;
    }

    public String getName() {
        return name;
    }
}
