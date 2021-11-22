package character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player joueur;

    @Before
    public void setUp() {
        joueur = new Player("Joueur 1");
    }

    @Test
    public void getNameTest() {
        System.out.println(joueur.getName());
    }

    @Test
    public void toStringTest() {
        System.out.println(joueur.toString());
    }

}