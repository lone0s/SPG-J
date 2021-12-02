package squid.command;

import squid.character.Player;
import squid.place.Place;

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
    //Récupère la commande
    public String getCommand() {
        return command;
    }
    //Affiche la description de la commande
    public void printHelp() {
        System.out.println(this.help);
    }
    //Méthode à override pour effectuer l'action de la commande
    public abstract void executeCommand(Player player, String[] args);
    //Liste des commandes
    private static List<Command> generateCommands(){
        List<Command> commandList = new ArrayList<>();

        commandList.add(new Quit());
        commandList.add(new Inventory());
        commandList.add(new Play());
        commandList.add(new Help());
        commandList.add(new Look());
        commandList.add(new Go());
        commandList.add(new Use());
        commandList.add(new Take());
        return commandList;
    }
}
