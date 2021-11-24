package squid.character;

import squid.item.Knife;
import org.junit.Before;
import org.junit.Test;
import squid.place.Place;

public class PlayerTest {
    private Player joueur;
    private Knife couteaux;
    private Place place;

    @Before
    public void setUp() {
        place = new Place("Mj1", "Random desc", new NPC("Thierry"));
        joueur = new Player("Joueur 1", place);
        couteaux = new Knife();
    }

    @Test
    public void getNameTest() {
        System.out.println(joueur.getName());
    }

    @Test
    public void toStringTest() {
        System.out.println(joueur.toString());
    }

    @Test
    public void addItemTest() {
        joueur.addItem(couteaux);
    }

    @Test
    public void removeItemTest() {
        joueur.addItem(couteaux);
        joueur.removeItem(couteaux);
    }

    @Test
    public void printEmptyInventoryTest(){
        joueur.printInventory();
    }

    @Test
    public void printInventoryTest(){
        joueur.addItem(couteaux);
        joueur.printInventory();
    }

    @Test
    public void getItemTest() {
        joueur.addItem(couteaux);
        joueur.getItems();
    }

}