package item;

import character.Player;

import java.util.Random;

public class Mag extends Item{

    private static final int MIN_AMMO = 20;
    private static final int MAX_AMMO = 50;

    private int nbAmmo;

    Mag() {
        super("Mag", "Utilise les chargeurs pour recharger ton arme !");
        this.setRandomAmmo();
    }

    public void setRandomAmmo() {
        Random nbAleatory = new Random();
        nbAmmo = nbAleatory.nextInt(MIN_AMMO, MAX_AMMO);
    }

    public int getNbAmmo() {
        return this.nbAmmo;
    }

    @Override
    public void use(Player player) {

    }
}
