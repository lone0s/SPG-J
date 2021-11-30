package squid.place.game;

import org.junit.Before;
import org.junit.Test;
import squid.character.Player;
import squid.exit.Exit;
import squid.place.Place;

import java.util.List;

public class ExitTest {
    Player player;
    List<Place> world;

    @Before
    public void setUp() {
        world = Place.genAllPlaces();
        player = new Player("Toto",world.get(0),world);
    }
    @Test
    public void test() {
        //System.out.println(player.getPlace().allExits());
        Exit.printAllowedExits(player.getPlace().getExits(),player.getPlace());
    }
}



