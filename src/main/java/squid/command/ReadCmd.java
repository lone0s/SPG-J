package squid.command;

import squid.character.Player;
import squid.place.Place;

public abstract class ReadCmd {
    // To interpret a command
    public static void interpretCommand(Player player, String command) {
        Command cmd = getCommand(command);
        cmd.executeCommand(player, command.split(" "));
    }

    // Static method to get the first word of a sentence in lower case
    public static String getFirstWord(String sentence) {
        return sentence.split(" ")[0].toLowerCase();
    }

    // To return a command
    private static Command getCommand(String command) {

        String mainCommand = getFirstWord(command);

        for (Command cmd: Command.commandList) {
            if (cmd.getCommand().equals(mainCommand)) {
                return cmd;
            }
        }

        return new Command("unknown", "") {
            @Override
            public void executeCommand(Player player, String[] args) {
                System.out.println("| Unknown command\n" +
                        "[*] Type help to get the list of commands");
            }
        };
    }
}