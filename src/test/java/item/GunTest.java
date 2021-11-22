package item;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GunTest {
        private Gun gun;

        @Before
        public void setUp() {
            gun = new Gun("Pistolet", "Ce pistolet tue.");
        }

        @Test
        public void testprintItem() {
            gun.printItem();
        }
}