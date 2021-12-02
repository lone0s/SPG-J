package squid.character;

import squid.item.Empty;
import squid.item.Item;

public class NPC extends Character {
    Item item;

    // Constructor

    public NPC(String name,Item item) {
        super(name);
        this.item = item;
    }

    // Methode pour afficher les dialogues du NPC
    public void dialog(String dialog) {
        System.out.println("[ " + this.getName() + " ] " + dialog);
    }

    // Methode pour vérifier si le NPC a un item
    public boolean hasItem() {
        return (!this.item.getName().equals("Empty"));
    }
    public static boolean hasItem(Player player) {
        return (!player.getPlace().getNpc().getItem().getName().equals("Empty"));
    }
    public Item getItem() {
        return item;
    }

    public void removeItem() {
        if (this.hasItem()) {
            this.item = new Empty();
        }
    }
}
