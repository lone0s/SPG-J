package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import org.junit.Before;
import org.junit.Test;
import squid.exit.Exit;
import squid.place.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindNumberTest {

    private FindNumber findNumber;
    private Player player;
    private Place place;
    private List<Place> world;

    @Before
    public void setUp() {
        List<Place> myWld = new ArrayList<>();
        myWld.add( new Place("Mj1", "Random desc", new NPC("Thierry"),Place.genExit2Ways(new HashMap<String, Exit>(),"Mj1","Hub")));
        //place = new Place("Mj1", "Random desc", new NPC("Thierry"),Place.genExit2Ways(new HashMap<String, Exit>(),"Mj1","Hub"));
        findNumber = new FindNumber();
        player = new Player("HOHOHOHOHOHOHOHOOO", myWld.get(0), myWld/*place*/ );
    }

    @Test
    public void playTest(){

        //findNumber.play(player);
        System.out.println(place.allExits());
    }

}