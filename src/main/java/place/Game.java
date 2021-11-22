package place;

import character.NPC;
import character.Player;

import java.util.ArrayList;

public abstract class Game extends Place {

    public static int NB_GAMES = 0;

    public Game(String name, String description, NPC npc){



    }


    public abstract void play(Player player);


}
