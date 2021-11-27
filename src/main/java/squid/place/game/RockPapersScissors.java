package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.place.Game;
import squid.Start;

import java.util.HashMap;
import java.util.Scanner;

public class RockPapersScissors extends Game {

    private static final int POINT_TO_WIN = 3;

    private int playerPoint;
    private int NPCPoint;

    private static final String[] choice = {
            "rock",
            "paper",
            "scissors"
    };

    public RockPapersScissors(){


        super("Rock, Papers, Scissors",
                "In this game you need to beat the man who is in front of you.",
                new NPC("Circle Guard"),
                genExit2Ways(new HashMap<String,Exit>(),"Rock, Papers, Scissors","Main Room")
        );
    }

    @Override
    public void play(Player player) {

        playerPoint = 0;
        NPCPoint = 0;

        System.out.println("\n--- Game launched ---\n");
        System.out.println("To play, type one of this proposition :");
        for (String proposition: choice) {
            System.out.println("- " + proposition);
        }
        System.out.println("Good luck!");

        this.getNpc().dialog("I take you in 3 rounds !");

        while (playerPoint < POINT_TO_WIN && NPCPoint < POINT_TO_WIN){

            String playerTurn = getPlayerTurn(player);
            int NPCTurn = getNPCTurn();

            checkWinner(playerTurn, NPCTurn);

            printPoint(player.getName());
            printPoint(this.getNpc().getName());

        }

        if (playerPoint == POINT_TO_WIN) {
            this.winner();
        } else {
            this.lose(player);
        }
        System.out.println("[*] Press enter for finish the game !");
        Start.scanner.nextLine();

        System.out.println("\n--- Game finished ---\n");
    }

    private int getNPCTurn(){
        int rand = (int)(Math.random()*3);

        this.getNpc().dialog(": " + choice[rand]);

        return rand;
    }

    private String getPlayerTurn(Player player) {
        Scanner scanner = Start.scanner;

        System.out.print(player);
        String playerTurn = scanner.nextLine();

        while (!checkPlayerTurn(playerTurn)) {
            this.getNpc().dialog("You haven't the right to use this!");
            System.out.print(player);
            playerTurn = scanner.nextLine();
        }

        return playerTurn;
    }

    public boolean checkPlayerTurn(String playerTurn){
        for (String proposition : choice) {
            if (playerTurn.equals(proposition)) {
                return true;
            }
        }
        return false;
    }


    public void printPoint(String name){

        int point;
        if (name.equals(this.getNpc().getName())){
            point = NPCPoint;
        } else {
            point = playerPoint;
        }

        System.out.println("- " + name + " : " + point + " point(s).");
    }

    public void checkWinner(String playerTurn, int NPCTurn){
        NPC npc = this.getNpc();

        if (playerTurn.equals(choice[NPCTurn])) {
            npc.dialog("Draw, I will get you in the next round !");
        } else if (playerTurn.equals(choice[(NPCTurn+1)%3])){
            playerPoint++;
        } else {
            NPCPoint++;
        }
    }

}
