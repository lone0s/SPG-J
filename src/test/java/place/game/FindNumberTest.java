package place.game;

import character.Player;
import org.junit.Before;
import org.junit.Test;

public class FindNumberTest {

    private FindNumber findNumber;
    private Player player;

    @Before
    public void setUp() {
        findNumber = new FindNumber();
        player = new Player("HOHOHOHOHOHOHOHOOO");
    }

    @Test
    public void playTest(){

        findNumber.play(player);

    }

}