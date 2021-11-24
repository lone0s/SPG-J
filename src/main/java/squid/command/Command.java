package squid.command;

import squid.character.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    public static final List<Command> commandList = generateCommands();

    private final String command;
    private final String help;

    //CONSTRUCTOR
    Command(String command, String help) {
        this.command = command;
        this.help = help;
    }

    public String getCommand() {
        return command;
    }

    public abstract void executeCommand(Player player, String[] args);

    private static List<Command> generateCommands(){
        List<Command> commandList = new ArrayList<>();

        commandList.add(new Quit());
        //commandList.add(new Go());

        return commandList;
    }
}
