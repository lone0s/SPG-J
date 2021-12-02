package squid;

import squid.character.Player;
import squid.command.ReadCmd;
import squid.place.Place;

import java.util.List;
import java.util.Scanner;

public class Start {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String command;
        List<Place> placeList = Place.genAllPlaces();
        System.out.println("""
                    ________________________\s
                   |  ____________________  |
                   | |                    | |
                   | | Squid Plagiat Game | |
                   | |                    | |
                   | |____________________| |
                   |________________________|
                """);


        System.out.print("[*] Please enter your username :");

        String username = scanner.nextLine();

        Player player = new Player(username, placeList.get(0),placeList);

        System.out.println("Welcome " + player.getName() + " to the Squid Plagiat Game.\n" +
                "You have been drugged and you wake up in a large room with several hundred players.\n" +
                "A scoreboard shows the number 456.\n" +
                "You are probably wondering what you are doing here.\n");

        player.getPlace().getNpc().dialog("Hello everyone,\n" +
                "you have chosen to participate in the Squid Game Plagiarism.\n" +
                " During the game, you will have to participate in different mini-games.\n" +
                " The goal is simple => win the game in order not to die.\n" +
                "Please indicate now what you want to do.\n");

        while (!player.getIsLose()) {
            System.out.print(player);
            command = scanner.nextLine();
            ReadCmd.interpretCommand(player, command);
        }

    }
}
