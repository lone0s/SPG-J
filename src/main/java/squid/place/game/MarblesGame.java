package squid.place.game;

import squid.Start;
import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.item.Empty;
import squid.place.Game;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class MarblesGame extends Game {

    private final static int DEFAULT_N_MARBLES = 10;
    private final static int MIN_RDM = 1;
    private final static int MAX_RDM = 10;


    public MarblesGame() {
        super("MarblesGame",
                "You and the NPC have 10 marbles.\nEach round, the NPC picks a number between 1 and 10." +
                        "\nYou'll have to guess weither the picked number is even or not.\nFirst one to get to 0 marbles loses." +
                        "\nGood luck gamer."
                ,new NPC("Marble Master",new Empty()), genExit2Ways(new HashMap<>(),"MarblesGame","MainRoom"));
    }

    @Override
    public void removePlayer() {
        int nPlayers = getNbPlayer() / 2;
        setNbPlayer(nPlayers);
        System.out.println("There's " + nPlayers + " players left!");
    }

    public void play(Player player) {

        int playerMarbles = DEFAULT_N_MARBLES;
        int npcMarbles = DEFAULT_N_MARBLES;
        int rdmValue;
        Scanner usrData = Start.scanner;
        String usrAnswer;

        System.out.println("\n--- Game launched ---\n");

        while (!someoneWon(playerMarbles, npcMarbles)) {
            this.getNpc().dialog("You have " + playerMarbles + " marbles, I have " + npcMarbles + " marbles.");
            rdmValue = rdmValue();
            this.getNpc().dialog("I have picked a random value, is it even ?[yes/no]");
            usrAnswer = usrData.nextLine();

            if(!checkYesNo(usrAnswer)) {
                this.getNpc().dialog("This is not a yes/no answer, please enter yes or no");
            }

            else{
                if (isEven(rdmValue)) {
                    if (usrAnswer.equals("yes")) {
                        this.getNpc().dialog("Right answer! Good job :)");
                        playerMarbles += rdmValue;
                        npcMarbles -= rdmValue;
                    } else {
                        this.getNpc().dialog("Wrong answer! Better luck next time :/");
                        playerMarbles -= rdmValue;
                        npcMarbles += rdmValue;
                    }
                }
                else {
                    if (usrAnswer.equals("yes")) {
                        this.getNpc().dialog("Wrong answer! Better luck next time :/");
                        playerMarbles -= rdmValue;
                        npcMarbles += rdmValue;
                    } else {
                        this.getNpc().dialog("Right answer! Good job :)");
                        playerMarbles += rdmValue;
                        npcMarbles -= rdmValue;
                    }
                }
            }
        }
        if(npcMarbles <= 0){
            this.removePlayer();
            winner();
            player.isInGame = false;
        }
        else {
            lose(player);
        }
    }

    public int rdmValue() {
        Random rdmGenerator = new Random();
        return (rdmGenerator.nextInt(MAX_RDM - MIN_RDM)+ MIN_RDM);
    }

    public boolean checkYesNo(String x) {
        return (x.equals("yes") || x.equals("no"));
    }
    public boolean isEven(int x) {
        return (x%2 == 0);
    }
    public boolean someoneWon(int nbMarblesPlayer, int nbMarblesNPC) {
        return (nbMarblesPlayer <= 0 || nbMarblesNPC <= 0);
    }

}
