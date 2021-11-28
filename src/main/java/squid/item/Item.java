package squid.item;

import squid.character.Player;

public abstract class Item {

    private final String name;
    private final String description;

    /**
     * @param name Indique le nom de l'squid.item
     * @param description Explique l'utilisation de l'squid.item
     */
    Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public void getDescription(){
        System.out.println(this.description);
    }

    public abstract void use(Player player);

    public void printItem () {
        System.out.println( "- " + this.name + " : " + this.description);
    }
}
