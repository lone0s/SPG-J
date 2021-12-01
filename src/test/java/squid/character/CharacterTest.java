package squid.character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CharacterTest {

    Character character1;
    Character character2;
    Character character3;

    @Before
    public void setUp(){
        character1 = new Character("Character 1") {};
        character2 = new Character("Character 2") {};
        character3 = character1;
    }

    @Test
    public void getName() {
        assertEquals(character1.getName(), "Character 1");
        assertEquals(character2.getName(), "Character 2");
        assertSame(character3.getName(), character1.getName());
    }

    @Test
    public void testToString() {
        assertEquals(character1.toString(), "[ Character 1 ] : ");
        assertEquals(character2.toString(), "[ Character 2 ] : ");
        assertEquals(character3.toString(), character1.toString());
    }
}