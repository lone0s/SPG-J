package squid.command;

import squid.character.Player;

import java.util.List;
import java.util.Locale;

public class Help extends Command{

    public Help() {
        super("help", "[*] help : To have the list of available command. \n [*] help <command> : To have help on a specified command. ");
    }

    @Override
    public void executeCommand(Player player, String[] args) {

        List<Command> commandList = Command.commandList;

        if (args.length > 1) {
            for (Command command : commandList) {
                if (command.getCommand().equals(args[1].toLowerCase())){
                    command.printHelp();
                    break;
                }
            }
        } else {
            System.out.println("[*] Command list :");
            for(Command command : commandList) {
                System.out.println("- " + command.getCommand());
            }
            System.out.println("[*] Type \"help <command>\" to get more information");
        }

    }
}
