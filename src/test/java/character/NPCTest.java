package character;

import org.junit.Before;
import org.junit.Test;

public class NPCTest {
    private NPC npc;

    @Before
    public void setUp() {
        npc = new NPC("Square");
    }

    @Test
    public void testDialog(){
        npc.dialog(" Hello c'est moi square !");
    }

}