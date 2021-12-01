package squid.command;

import org.junit.Test;
import squid.character.Player;
import squid.place.Place;

import java.util.List;

import static org.junit.Assert.*;

public class ReadCmdTest{

    @Test
    public void getFirstWord(){
        assertEquals(ReadCmd.getFirstWord("use gun"), "use");
        assertEquals(ReadCmd.getFirstWord("look knife"), "look");
        assertEquals(ReadCmd.getFirstWord("quit "), "use");
    }

}