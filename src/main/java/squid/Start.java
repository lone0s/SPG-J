package squid;

import squid.character.Player;
import squid.place.game.FindNumber;
import squid.place.game.GlassBridge;
import squid.place.game.RockPapersScissors;

import java.util.Scanner;

public class Start {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        RockPapersScissors gb = new RockPapersScissors();
        Player player = new Player("George");
        gb.play(player);

    }
}
