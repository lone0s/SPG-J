package squid.item;

import squid.character.Player;

public class Gun extends Item {

    private final static String name = "Pistolet";
    private final static String description = "Pour utiliser ce pistolet, il faut posséder un chargeur.";

    /**
     * Ce constructeur créer un pistolet avec une explication pour l'utiliser.
     */
    public Gun() {
        super(name, description);
    }

    @Override
    public void use(Player player) {
    }

    /**
     * Affichage du pistolet
     */
    @Override
    public void printItem() {
        super.printItem();
    }
}
