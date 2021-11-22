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
    public void testprintItem() {
        couteaux.printItem();
    }

}