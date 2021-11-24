package place.game;

import character.NPC;
import character.Player;
import place.Game;
import principal.Start;

import java.util.Scanner;

public class FindNumber extends Game {

    private final static int MAX_NUMBER = 999;
    private final static int MAX_ATTEMPT = 15;

    public FindNumber(){
        super("Find Number",
                "ADD DESCRIPTION TA MERE",
                new NPC("BOBY")
        );
    }

    @Override
    public void play(Player player) {
        Scanner scanner = Start.scanner;
        int rand = (int) (Math.random() * (MAX_NUMBER));
        int chosenNumber;
        int attempt = MAX_ATTEMPT;

        System.out.println("\n--- Game launched ---\n");

        this.getNpc().dialog("Explication des règles");

        while (attempt > 0) {

            System.out.print(player);

            try {
                chosenNumber = scanner.nextInt();
            } catch (Exception exception) {
                scanner.nextLine();
                this.getNpc().dialog("You need to write a number!");
                continue;
            }

            if(chosenNumber > MAX_NUMBER || chosenNumber < 0) {
                this.getNpc().dialog("Please enter a number between 0 and 999");
            } else {
                attempt--;

                if (attempt == 0 && chosenNumber != rand) {
                    this.getNpc().dialog("The number was " + rand);
                    break;
                } else {

                    if (rand > chosenNumber) {
                        this.getNpc().dialog("It's more!");
                    } else if (rand < chosenNumber) {
                        this.getNpc().dialog("It's less!");
                    } else {
                        this.getNpc().dialog("Congrats you win");
                        break;
                    }
                    this.getNpc().dialog("You only have " + attempt + " attempts left!");

                }
            }

        }

        scanner.nextLine();

        System.out.println("\n--- Game finished ---\n");


    }
}
