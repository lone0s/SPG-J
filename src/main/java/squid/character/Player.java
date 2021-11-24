package squid.character;

import squid.item.Item;
import java.util.ArrayList;
import java.util.List;

public class Player extends Character{
    static final int DEFAULT_LIVE = 1;
    Boolean IsLose = false;
    List<Item> Items= new ArrayList<Item>();

    /**
     * @param name Nom du joueur
     */
    public Player(String name) {
        super(name);
    }

    /**
     * @param item Item à rajouté dans la liste d'squid.item du joueur
     */
    public void addItem(Item item) {
        Items.add(item);
    }

    /**
     * @param item Item à supprimer
     */
    public void removeItem(Item item) {
        // Méthode fonctionne mais n'est pas au top
        // On boucle pour être sur de supprimer toutes les occurences de l'squid.item.
        while(Items.remove(item)){}
    }

    public void getItem() {
        System.out.println("Liste d'objets :");
        for (Item item : this.Items) {
            item.printItem();
        }
        System.out.println();
    }
}
