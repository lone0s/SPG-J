package squid.command;

import squid.character.Player;
import squid.item.Gun;
import squid.item.Item;
import squid.item.Knife;
import squid.place.Place;

import java.util.List;

public class Use extends Command{

    Use() {
        super("use", "Comment utiliser une arme ?");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (player.getPlace().getName().equalsIgnoreCase("MainRoom")) {
            List<Item> items = player.getItems();

            if (args[1].equalsIgnoreCase("Knife")) {
                boolean valid = false;
                for (int compteur = 0 ; compteur < items.size() ; compteur++) {
                    if (items.get(compteur).getName().equalsIgnoreCase("Knife")) {
                        Item knife = items.get(compteur);
                        knife.use(player);
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    System.out.println("[*] You don't have knife.");
                }
            }

            else if (args[1].equalsIgnoreCase("Mag")) {
                boolean valid = false;
                for (int compteur = 0 ; compteur < items.size() ; compteur++) {
                    if (items.get(compteur).getName().equalsIgnoreCase("Mag")) {
                        Item mag = items.get(compteur);
                        mag.use(player);
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    System.out.println("[*] You don't have mag.");
                }
            }

            else if (args[1].equalsIgnoreCase("Gun")) {
                boolean valid = false;
                for (int compteur = 0 ; compteur < items.size() ; compteur++) {
                    if (items.get(compteur).getName().equalsIgnoreCase("Gun")) {
                        Item gun = items.get(compteur);
                        gun.use(player);
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    System.out.println("[*] You don't have gun.");
                }
            }

            else {
                System.out.println("[*] The name of object is incorrect.");
            }
        }
        else {
            System.out.println("You are not in the hub.");
        }

    }
}