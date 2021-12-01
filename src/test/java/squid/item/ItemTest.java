package squid.item;

import squid.character.Player;
import org.junit.Before;
import org.junit.Test;
import squid.place.Place;

public class ItemTest {

    private Item item;

    @Before
    public void setUp(){

        item = new Item("TestItem","This is a test Description of an Item") {
            @Override
            public void use(Player player) {

            }
        };
    }

    @Test
    public void printItemTest(){
        item.printItem();
    }

}