package command;

import character.Player;

public class Inventory extends Command {


    Inventory(String command, String help) {
        super(command, help);
    }

    @Override
    public void executeCommand(Player player, String[] args) {

    }
}