package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import org.junit.Before;
import org.junit.Test;
import squid.place.Place;

public class FindNumberTest {

    private FindNumber findNumber;
    private Player player;
    private Place place;

    @Before
    public void setUp() {
        place = new Place("Mj1", "Random desc", new NPC("Thierry"));
        findNumber = new FindNumber();
        player = new Player("HOHOHOHOHOHOHOHOOO", place);
    }

    @Test
    public void playTest(){

        findNumber.play(player);

    }

}