package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import squid.place.Game;

public class Crabs extends Game {
    public Crabs() {
        super("Crabs", "Description du jeu",
                new NPC("GB_NPC"));
    }

    @Override
    public void play(Player player) {

    }
}
