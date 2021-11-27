package squid.place.game.TicTacToe;

import org.junit.Before;
import org.junit.Test;
import squid.character.NPC;
import squid.character.Player;
import squid.place.Place;

public class TicTacToeTest {
    private Place place;
    private Player player;
    private TicTacToe crabs;

    @Before
    public void setUp() {
        place = new Place("Mj1", "Random desc", new NPC("Thierry"));
        player = new Player("Alessandro", place);
        crabs = new TicTacToe();
    }

    @Test
    public void play() {
        crabs.play(player);
    }
}