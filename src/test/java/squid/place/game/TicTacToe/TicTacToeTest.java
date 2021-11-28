package squid.place.game.TicTacToe;

import org.junit.Before;
import org.junit.Test;
import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.place.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicTacToeTest {
    private Place place;
    private Player player;
    private List<Place> world;
    private TicTacToe crabs;

    @Before
    public void setUp() {
        List<Place> myWld = new ArrayList<Place>();
        place = new Place("Mj1", "Random desc", new NPC("Thierry"),Place.genExit2Ways(new HashMap<String, Exit>(),"Mj1","Hub"));
        player = new Player("Alessandro", place,myWld);
        crabs = new TicTacToe();
    }

    @Test
    public void play() {
        crabs.play(player);
    }
}