package item;

import character.Player;

import java.util.Random;

public class Mag extends Item{

    private static final int MIN_AMMO = 20;
    private static final int MAX_AMMO = 50;

    private int nbAmmo;

    // Creating a mag with a random number of bullets between 20 and 50.
    Mag() {
        super("Mag", "Utilise les chargeurs pour recharger ton arme !");
        this.setRandomAmmo();
    }

    //
    public void setRandomAmmo() {
        Random nbAleatory = new Random();
        nbAmmo = MIN_AMMO + nbAleatory.nextInt(MAX_AMMO - MIN_AMMO + 1);
    }

    public int getNbAmmo() {
        return this.nbAmmo;
    }

    @Override
    public void use(Player player) {

    }
}
