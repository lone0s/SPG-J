package character;

import item.Item;
import item.Knife;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player joueur;
    private Knife couteaux;

    @Before
    public void setUp() {
        joueur = new Player("Joueur 1");
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
    public void getItemTest() {
        joueur.addItem(couteaux);
        joueur.getItem();
    }

}