package place.game;

import character.Player;
import item.Knife;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GlassBridgeTest {

    private Player player;
    private GlassBridge pontVerre;

    @Before
    public void setUp() {
        player = new Player("George");
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