package squid.place.game;

import org.junit.Before;
import org.junit.Test;
import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.item.Empty;
import squid.place.Place;
import squid.place.game.GuessMyWord.GuessMyWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuessMyWordTest {
    private GuessMyWord guessMyWordgame;
    private Player player;
    private Place place;
    private List<Place> world;


    @Before
    public void setUp() {
        world = new ArrayList<>();
        place = new Place("Mj1", "Random desc", new NPC("Thierry",new Empty()),Place.genExit2Ways(new HashMap<String, Exit>(),"Mj1","Hub"));
        world.add(place);
        guessMyWordgame = new GuessMyWord();
        player = new Player("okMek", place, world );
    }

    @Test
    public void playTest() {
        guessMyWordgame.play(player);
    }
}
