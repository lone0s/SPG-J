package squid.place;

import squid.character.NPC;
import squid.character.Player;
import squid.command.Play;
import squid.exit.Exit;

import java.util.HashMap;
import java.util.Locale;

public abstract class Game extends Place {

    public static int NB_GAMES = 0;

    public Game(String name, String description, NPC npc/*, HashMap<String, Exit> exits*/){
       super(name, description, npc/*,exits*/);
   }

    public abstract void play(Player player);

    public void winner(){
        System.out.println("[*] : Congratulations, you have won " + this.getName() + " mini-game, you can go back to the hub !");
    }

    public void lose(Player player){
        player.setIsLose();
        System.out.println("[*] : You lost on the " + this.getName() + " mini-game, restart the game to try your luck again !");
    }
}
