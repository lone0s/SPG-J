package squid.command;

import squid.character.Player;
import squid.item.Knife;
import squid.place.Place;

public class Use extends Command{

    Use() {
        super("use", "Comment utiliser une arme ?");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        if (args[1].equalsIgnoreCase("Kniffe")) {
            Knife knife = new Knife();
            knife.setRandomKill(player.getPlace());
        }
    }
}