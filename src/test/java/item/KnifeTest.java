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
    public void randomKillTest() {
        for (int compteur = 1 ; compteur <= 10 ; compteur++) {
            System.out.println("Le nombre de personne tuées est de : " + couteaux.randomKill());
        }
    }

}