package code.item;

import code.character.Player;

public abstract class Item {

    private final String name;
    private final String description;

    Item(String name, String description) {
        this.name = name;
        this.description = description;

    }


    public abstract void use (Player player);


    public void printItem (){
        System.out.println( "- " + this.name + " : " + this.description);
    }
}
