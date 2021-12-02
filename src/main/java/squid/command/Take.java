package squid.command;

import squid.character.NPC;
import squid.character.Player;

import java.util.Scanner;

public class Take extends Command{

    public Take() {
        super("take","If the NPC has an Item to offer, type <take Name_Of_The_Item>");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (args.length == 1) {
            player.getPlace().getNpc().dialog("You haven't typed anything, type <help take> to get indications on how to use this command");
        }
        else if (NPC.hasItem(player)) {
            switch (args[1]) {
                case "Knife" :
                    if (player.getPlace().getNpc().getItem().getName().equals("Knife")) {
                        player.takeItemFromNpc();
                    }
                    break;
                case "Mag" :
                    if (player.getPlace().getNpc().getItem().getName().equals("Mag")) {
                        player.takeItemFromNpc();
                    }
                    break;
                case "Gun" :
                    if (player.getPlace().getNpc().getItem().getName().equals("Gun")) {
                        player.takeItemFromNpc();
                    }
                    break;
            }
        }
        else {
            player.getPlace().getNpc().dialog("[*] I haven't got anything to give you, now please leave.");
        }
    }

}
