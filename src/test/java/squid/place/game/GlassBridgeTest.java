package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.item.Knife;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import squid.place.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GlassBridgeTest {

    private Player player;
    private GlassBridge pontVerre;
    private Place place;
    private List<Place> world;

    @Before
    public void setUp() {
        world = new ArrayList<>();
        place = new Place("Mj1", "Random desc", new NPC("Thierry"),Place.genExit2Ways(new HashMap<String, Exit>(),"Mj1","Hub"));
        world.add(place);
        player = new Player("George", place,world);
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