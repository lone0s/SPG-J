package squid.character;

import squid.item.Knife;
import org.junit.Before;
import org.junit.Test;
import squid.place.Place;
import squid.exit.Exit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerTest {
    private Player joueur;
    private Knife couteaux;
    //private Place place;
    private List<Place> world;

    @Before
    public void setUp() {
        List<Place> world = new ArrayList<Place>();
        world.add(new Place("Mj1", "Random desc", new NPC("Thierry"),Place.genExit2Ways(new HashMap<String,Exit>(),"Mj1","Hub")));
        world.add(new Place("Hub","Rdm Desc",new NPC ("Henry"),Place.genExit2Ways(new HashMap<String,Exit>(),"Hub","Mj1")));
        joueur = new Player("Joueur 1", world.get(0),world);
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
    @Test
    public void useExit() {
        System.out.println(joueur.getPlace().getName());
        joueur.useExit("Hub");
        System.out.println(joueur.getPlace().getName());
    }

}