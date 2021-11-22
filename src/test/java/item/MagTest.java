package item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MagTest {

    private Mag mag;

    @Before
    public void setUp() {
        mag = new Mag();
    }

    @Test
    public void getNbAmmoTest(){
        System.out.println("Le chargeur possède " + mag.getNbAmmo() + " munitions.");
    }

    @Test
    public void printItemTest() {
        mag.printItem();
    }

}