package squid.place.game;

import org.junit.Before;
import org.junit.Test;
import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.item.Empty;
import squid.place.Place;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ExitTest {
    Exit mainRoom;
    Exit guessMyWord;

    @Before
    public void setUp() {
        mainRoom = new Exit("MainRoom","GuessMyWord") ;
        guessMyWord = new Exit ("GuessMyWord","MainRoom");

    }
    @Test
    public void test() {
        //System.out.println(player.getPlace().allExits());
        assertEquals(mainRoom.getDest(),guessMyWord.getSrc());
        assertEquals(mainRoom.getSrc(),guessMyWord.getDest());
        assertSame(mainRoom.getSrc(),guessMyWord.getDest());
        assertSame(mainRoom.getDest(),guessMyWord.getSrc());
    }

    @Test
    public void testStr() {
        assertEquals(mainRoom.getDest(),"GuessMyWord");
        assertEquals(guessMyWord.getDest(),"MainRoom");
    }

}



