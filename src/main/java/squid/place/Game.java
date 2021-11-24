package squid.place;

import squid.character.NPC;
import squid.character.Player;

public abstract class Game extends Place {

    public static int NB_GAMES = 0;

    public Game(String name, String description, NPC npc){
       super(name, description, npc);
   }

    public abstract void play(Player player);

    public void winner(Player player){
        System.out.println("[Game Master] : Congratulations, you have won a mini-game, you can go back to the hub");
    }
}
