package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import squid.item.Knife;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import squid.place.Place;

public class GlassBridgeTest {

    private Player player;
    private GlassBridge pontVerre;
    private Place place;

    @Before
    public void setUp() {
        place = new Place("Mj1", "Random desc", new NPC("Thierry"));
        player = new Player("George", place);
        pontVerre = new GlassBridge();
    }

    @Test
    public void play() {
        pontVerre.play(player);
    }

    @org.junit.Test
    public void bridgePrint() {
    }
}