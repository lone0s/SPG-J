package place.game;

import character.NPC;
import character.Player;
import org.junit.Before;
import org.junit.Test;

public class RockPapersScissorsTest {

    private RockPapersScissors rps;
    private Player player;

    @Before
    public void setUp() {
       rps = new RockPapersScissors();
       player = new Player("George");
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