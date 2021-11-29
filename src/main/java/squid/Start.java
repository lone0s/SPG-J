package squid;

import squid.character.Player;
import squid.command.ReadCmd;
import squid.item.Item;
import squid.item.Knife;
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

        Player player = new Player(username, placeList.get(1),placeList);
        player.addItem(new Knife());

        player.getPlace().getNpc().dialog("Welcome to the squid game plagiat game");

        while (!player.getIsLose()) {
            System.out.print(player);
            command = scanner.nextLine();
            ReadCmd.interpretCommand(player, command);
        }

    }
}
