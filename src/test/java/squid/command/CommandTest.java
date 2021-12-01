package squid.command;

import org.junit.Before;
import org.junit.Test;
import squid.character.Player;

import static org.junit.Assert.*;

public class CommandTest{

    Command command1;
    Command command2;
    Command command3;

    @Before
    public void setUp(){
        command1 = new Command("Command1", "Desc Command 1") {
            @Override
            public void executeCommand(Player player, String[] args) {
                System.out.println("Execute command 1");
            }
        };
        command2 = new Command("Command2", "Desc Command 2") {
            @Override
            public void executeCommand(Player player, String[] args) {
                System.out.println("Execute command 2");
            }
        };
        command3 = command1;
    }

    @Test
    public void getCommand(){
        assertEquals(command1.getCommand(), "Command1");
        assertEquals(command2.getCommand(), "Command2");
        assertSame(command3.getCommand(), command1.getCommand());
    }


}