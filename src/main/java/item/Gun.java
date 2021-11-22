package item;

import character.Player;

public class Gun extends Item {

    private final static String name = "Pistolet";
    private final static String description = "Pour utiliser ce pistolet, il faut posséder un chargeur.";

    /**
     * Ce constructeur créer un pistolet avec une explication pour l'utiliser.
     */
    Gun() {
        super(name, description);
    }

    @Override
    public void use(Player player) {
    }

    @Override
    public void printItem() {
        super.printItem();
    }
}
