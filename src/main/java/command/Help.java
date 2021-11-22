package command;

import character.Player;

public class Help extends Command{

    Help(String command, String help) {
        super(command, help);
    }

    @Override
    public void executeCommand(Player player, String[] args) {

    }
}
