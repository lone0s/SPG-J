package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.item.Knife;
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
                " In this game you have to find the number thought by the NPC",
                new NPC("Square Guard",new Knife()),genExit2Ways(new HashMap<>(),"FindNumber","MainRoom"));
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
        player.isInGame = true;
        System.out.println("\n--- Game launched ---\n");

        this.getNpc().dialog(" In this game you have to find the number i'm thinking about :)");

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
                        this.removePlayer();
                        this.winner();
                        if (this.getNpc().hasItem()) {
                            this.getNpc().dialog("[*] Before you go, take this " + this.getNpc().getItem().getName() + " with you. \n[<help take> if you don't know how to take an item]");
                        }
                        player.isInGame = false;
                        break;
                    }
                    this.getNpc().dialog(" You only have " + attempt + " attempts left!");

                }
            }

        }

        scanner.nextLine();

        // System.out.println("\n--- Game finished ---\n");

    }


}
