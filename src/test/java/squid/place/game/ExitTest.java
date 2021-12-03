package squid.place.game;

import org.junit.Before;
import org.junit.Test;
import squid.exit.Exit;

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
        assertEquals(mainRoom.getDest(),guessMyWord.getSrc());
        assertEquals(mainRoom.getSrc(),guessMyWord.getDest());
        assertSame(mainRoom.getSrc(),guessMyWord.getDest());
        assertSame(mainRoom.getDest(),guessMyWord.getSrc());
    }

    @Test
    public void testStr() {
        assertEquals(mainRoom.getSrc(),"MainRoom");
        assertEquals(mainRoom.getDest(),"GuessMyWord");
        assertEquals(mainRoom.getDest(),"GuessMyWord");
        assertEquals(guessMyWord.getDest(),"MainRoom");
    }

}



