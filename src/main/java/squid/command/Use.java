package squid.command;

import squid.character.Player;
import squid.item.Item;
import squid.item.Knife;

import java.util.List;

public class Use extends Command{

    Use() {
        super("use", "Comment utiliser une arme ?");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (args[1].equalsIgnoreCase("Kniffe")) {
            Knife knife = new Knife();
            knife.use(player);
        }

        else if (args[1].equalsIgnoreCase("Mag")) {
            List<Item> items = player.getItems();

            for (int compteur = 0 ; compteur < items.size() ; compteur++) {
                if (items.get(compteur).getName().equalsIgnoreCase("Mag")) {
                    Item mag = items.get(compteur);
                    mag.use(player);
                    break;
                }
            }
        }
    }
}