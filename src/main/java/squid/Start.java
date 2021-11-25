package squid;

import squid.character.Player;
import squid.command.Interpreter;
import squid.place.Place;

import java.util.List;
import java.util.Scanner;

public class Start {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String command;
        List<Place> placeList = Place.genAllPlaces();

        System.out.println("[*] Please enter your username !");

        String username = scanner.nextLine();

        Player player = new Player(username, placeList.get(0));

        player.getPlace().getNpc().dialog("Welcome to the squid game plagiat game");

        while (!player.getIsLose()) {
            System.out.print(player);
            command = scanner.nextLine();
            Interpreter.interpretCommand(player, command);
        }

    }
}
