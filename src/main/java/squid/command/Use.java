package squid.command;

import squid.character.Player;
import squid.item.Knife;
import squid.place.Place;

public class Use extends Command{

    Use(String command, String help) {
        super("Utiliser une arme", "Comment utiliser une arme ?");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        Knife knife = new Knife();
        knife.setRandomKill(this.place);
    }
}
