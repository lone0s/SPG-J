package item;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GunTest {
        private Gun gun;

        @Before
        public void setUp() {
            gun = new Gun();
        }

        @Test
        public void testprintItem() {
            gun.printItem();
        }
}