package item;

import character.Player;

public abstract class Item {

    private final String name;
    private final String description;

    /**
     * @param name Indique le nom de l'item
     * @param description Explique l'utilisation de l'item
     */
    Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void use(Player player);

    public void printItem () {
        System.out.println( "- " + this.name + " : " + this.description);
    }
}
