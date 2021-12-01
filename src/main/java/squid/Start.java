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
        /*System.out.println("    ________________________ \n" +
                "   |  ____________________  |\n" +
                "   | |                    | |\n"+
                "   | | Squid Plagiat Game | |\n" +
                "   | |                    | |\n"+
                "   | |____________________| |\n" +
                "   |________________________|\n");*/
        System.out.println("[*] Please enter your username !");

        String username = scanner.nextLine();

        Player player = new Player(username, placeList.get(0),placeList);

        player.getPlace().getNpc().dialog("Welcome to the squid game plagiat game\n");

        while (!player.getIsLose()) {
            System.out.print(player);
            command = scanner.nextLine();
            ReadCmd.interpretCommand(player, command);
        }

    }
}
