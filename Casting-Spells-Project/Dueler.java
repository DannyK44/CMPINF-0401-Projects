/*
 * Created on Wed Jan 31 2024
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */
import java.util.Random;

class Dueler {
    private String name;
    private int impact = 0;
    private boolean unconscious = false;
    
    public Dueler(String name) {
        this.name = name;
        this.impact = 0;
        this.unconscious = false;
    }

    public int castSpell(Dueler target) {

        /// Three possible spells to be cast
        Spell stupefy = new Spell("Stupefy");
        Spell protego = new Spell("Protego");
        Spell expelliarmus = new Spell("Expelliarmus");

        Random random = new Random();
        int spellNumber = random.nextInt(10);

        int spellImpact = 0;

        // Determining which spell is cast, depending on randomly generated number
        if (spellNumber < 3) {
            spellImpact = expelliarmus.getImpact();

            System.out.println(name + " casts " + expelliarmus.getName() + " (" + spellImpact + ")");
            target.receiveImpact(spellImpact);
        } else if (spellNumber < 6) {
            spellImpact = protego.getImpact();

            System.out.println(name + " casts " + protego.getName() + " (" + spellImpact + ")");
            target.receiveImpact(spellImpact);
        } else {
            spellImpact = stupefy.getImpact();

            if (spellImpact == 10) {
                System.out.println(name + " casts " + stupefy.getName() + " (" + spellImpact + ")");
                spellImpact = 50;
                target.receiveImpact(spellImpact);
                target.unconscious = true;
                return spellImpact;
            } else {
                System.out.println(name + " casts " + stupefy.getName() + " (" + spellImpact + ")");
                target.receiveImpact(spellImpact);
            }
        }
        
        return spellImpact;
        
    }

    public void receiveImpact(int impact) {
        // total impact on duel
        this.impact += impact;
    }

    public String getName() {
        return name;
    }

    public int getImpact() {
        return impact;
    }

    public boolean getUnconscious() {
        return unconscious;
    }

}
