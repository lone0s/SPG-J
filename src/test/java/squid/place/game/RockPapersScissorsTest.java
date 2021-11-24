package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import org.junit.Before;
import org.junit.Test;
import squid.place.Place;

public class RockPapersScissorsTest {

    private RockPapersScissors rps;
    private Player player;
    private Place place;

    @Before
    public void setUp() {
        place = new Place("Mj1", "Random desc", new NPC("Thierry"));
        rps = new RockPapersScissors();
        player = new Player("George", place);
    }

    @Test
    public void playTest(){

        rps.play(player);

    }

    @Test
    public void checkPlayerTurnTest(){

        boolean test = rps.checkPlayerTurn("rock");

        System.out.println(test);

    }

    @Test
    public void printPointTest(){

        rps.printPoint(player.getName());

        rps.printPoint(rps.getNpc().getName());

    }

    @Test
    public void checkWinnerTest(){

        rps.checkWinner("rock", 2);

        rps.checkWinner("rock", 1);

        rps.checkWinner("rock", 0);

    }


}