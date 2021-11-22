package character;

import item.Item;

import java.util.List;

public class Player extends Character{
    static final int DEFAULT_LIVE = 1;
    Boolean IsLose = false;
    List<Item> Items;

    /**
     * @param name Nom du joueur
     */
    public Player(String name) {
        super(name);
    }

    /**
     * @param item Item à rajouté dans la liste d'item du joueur
     */
    public void addItem(Item item) {
        Items.add(item);
    }

    /**
     * @param item Item à supprimer
     */
    public void removeItem(Item item) {
        // On boucle pour être sur de supprimer toutes les occurences de l'item.
        while(Items.remove(item)){}
    }
}
