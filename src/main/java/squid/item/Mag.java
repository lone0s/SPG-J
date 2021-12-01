package squid.item;

import squid.character.Player;

import java.util.Random;

public class Mag extends Item {
    private static final int MIN_AMMO = 20;
    private static final int MAX_AMMO = 50;

    private int nbAmmo = -1;

    /**
     * Creating a mag with a random number of bullets between 20 and 50.
     */
    public Mag() {
        super("Mag", "Use the mags to reload your weapon !");
    }


    /**
     * Define how many bullets will be created
     */
    public void setRandomAmmo() {
        Random nbAleatory = new Random();
        nbAmmo = MIN_AMMO + nbAleatory.nextInt(MAX_AMMO - MIN_AMMO + 1);
    }

    /**
     * @return Getter how many balls will be created
     */
    public int getNbAmmo() {
        return this.nbAmmo;
    }

    /**
     * @param player player of the game
     */
    @Override
    public void use(Player player) {
        if (this.getNbAmmo() == -1) {
            this.setRandomAmmo();
            System.out.println("[*] The mag has " + this.getNbAmmo() + " bullets.");
        }
        else {
            System.out.println("[*] The mag was already charged. He has " + this.getNbAmmo() + " bullets.");
        }
    }
}
