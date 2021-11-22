package item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        System.out.println("Le couteaux tue " + couteaux.getRandomKill() + " personnes.");
    }
}