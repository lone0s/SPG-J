package squid.item;

import org.junit.Before;
import org.junit.Test;

public class KnifeTest {
    private Knife couteaux;


    @Before
    public void setUp() {
        couteaux = new Knife();
    }

    @Test
    public void printItemTest() {
        couteaux.printItem();
    }

    @Test
    public void getRandomKillTest() {
        for (int compteur = 1 ; compteur <= 10 ; compteur++) {
            couteaux = new Knife();
            System.out.println("Le couteaux tue " + couteaux.getRandomKill() + " personnes.");
        }
    }
}