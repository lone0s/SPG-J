package item;

import character.Player;

import java.util.Random;

public class Knife extends Item {
    private static final String name = "Couteaux";
    private static final String description = "Ce couteaux peut être utiliser pour tuer un nombre aléatoire de personnes.";

    private static final int MIN_KILL = 1;
    private static final int MAX_KILL = 5;

    /**
     * Ce constructeur créer un couteaux avec une explication pour l'utiliser.
     */
    public Knife() {
        super(name, description);
    }

    /**
     * @return Nombre aléatoire de personnes tué par un couteaux.
     */
    public int randomKill() {
        Random nbAleatory = new Random();
        return MAX_KILL + nbAleatory.nextInt(MAX_KILL - MIN_KILL);
    }

    @Override
    public void use(Player player) {
    }

    /**
     * Affichage du couteaux
     */
    @Override
    public void printItem() {
        super.printItem();
    }

}
