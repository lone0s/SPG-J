package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.place.Game;
import squid.Start;
import squid.place.Place;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class FindNumber extends Game {

    private final static int MAX_NUMBER = 999;
    private final static int MAX_ATTEMPT = 12;

    public FindNumber(){
        super("FindNumber",
                " In this game you have to find a number thought by the man",
                new NPC("Square Guard"),genExit2Ways(new HashMap<>(),"FindNumber","MainRoom"));
    }

    @Override
    public void removePlayer() {
        int nbPlayer = getNbPlayer();
        Random nbAleatory = new Random();
        nbPlayer = 25 + nbAleatory.nextInt(nbPlayer/2 - 25 + 1);
        setNbPlayer(nbPlayer);
        System.out.println("[*] Il reste maintenant " + nbPlayer + " players !");
    }

    @Override
    public void play(Player player) {
        Scanner scanner = Start.scanner;
        int rand = (int) (Math.random() * (MAX_NUMBER));
        int chosenNumber;
        int attempt = MAX_ATTEMPT;

        System.out.println("\n--- Game launched ---\n");

        this.getNpc().dialog(" In this game you have to find a number thought by the man");

        while (attempt > 0) {

            System.out.print(player);

            try {
                chosenNumber = scanner.nextInt();
            } catch (Exception exception) {
                scanner.nextLine();
                this.getNpc().dialog(" You need to write a number!");
                continue;
            }

            if(chosenNumber > MAX_NUMBER || chosenNumber < 0) {
                this.getNpc().dialog(" Please enter a number between 0 and 999");
            } else {
                attempt--;

                if (attempt == 0 && chosenNumber != rand) {
                    this.getNpc().dialog(" The number was " + rand);
                    this.lose(player);
                    break;
                } else {

                    if (rand > chosenNumber) {
                        this.getNpc().dialog(" It's more!");
                    } else if (rand < chosenNumber) {
                        this.getNpc().dialog(" It's less!");
                    } else {
                        this.winner();
                        this.removePlayer();
                        break;
                    }
                    this.getNpc().dialog(" You only have " + attempt + " attempts left!");

                }
            }

        }

        scanner.nextLine();

        System.out.println("\n--- Game finished ---\n");

    }


}
