package squid.command;

import squid.character.Player;
import squid.exit.Exit;
import squid.place.Place;


public class Go extends Command{
    public Go() {
        super("go","go : This command let's you use an existing door in your current room in order to access another room !\nUSE ==> <go MapName>");
    }


    @Override
    public void executeCommand(Player player, String[] args) {
        if ((args.length == 1)){
            System.out.println("[*] You haven't typed anything, type <help go> to get indications on how to use this command");
        }
        else if (!Place.placeExists(args[1],player.getPlace().getExits())) {
            System.out.println("[*] You've either typed the map wrong, or this is not an accessible exit");
            Exit.printAllowedExits(player.getPlace().getExits(), player.getPlace());
            System.out.println("[*] Please type one of the map names that are listed above exactly as it's written");
        }
        else {
            player.useExit(args[1]);
        }
    }
}
