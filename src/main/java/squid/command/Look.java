package squid.command;

import squid.character.Player;
import squid.item.Item;
import squid.place.Place;

public class Look extends Command{

    public Look() {
        super("look",
                "[*] look : Use this command to read the description of an objet or a place !");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        Place playerPlace = player.getPlace();

        if (args.length == 1){
            playerPlace.getDescription();
        } else {
            String arg = args[1].toLowerCase();

            for (Item playerItem : player.getItems()){
                if (ReadCmd.getFirstWord(playerItem.getName()).equalsIgnoreCase(arg)){
                    playerItem.getDescription();
                    return;
                }
            }
            System.out.println("[*] This item is not in your inventory !");
        }
    }
}
