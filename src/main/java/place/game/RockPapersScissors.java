package place.game;

import character.NPC;
import character.Player;
import place.Game;
import principal.Start;

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
        super("Rock, Papers, Scissors :",
                "In this game you need to beat at roshambo the man who is in front of you.\\n Type \\\"play\\\" to start the game.",
                new NPC("RPC NPC")
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

        this.getNpc().dialog(" I take you in 3 rounds !");

        while (playerPoint < POINT_TO_WIN && NPCPoint < POINT_TO_WIN){

            String playerTurn = getPlayerTurn(player);
            int NPCTurn = getNPCTurn();

            checkWinner(playerTurn, NPCTurn);

            printPoint(player.getName());
            printPoint(this.getNpc().getName());

        }

        if (playerPoint == POINT_TO_WIN) {
            this.getNpc().dialog("GG ta win FD¨P");
        } else {
            this.getNpc().dialog("ET c'est la lose");
        }

        principal.Start.scanner.nextLine();

        System.out.println("\n--- Game finished ---\n");
    }

    private int getNPCTurn(){
        int rand = (int)(Math.random()*3);

        this.getNpc().dialog(choice[rand]);

        return rand;
    }

    private String getPlayerTurn(Player player) {
        Scanner scanner = Start.scanner;

        System.out.print(player);
        String playerTurn = scanner.next();

        while (!checkPlayerTurn(playerTurn)) {
            this.getNpc().dialog("You haven't the right to use this!");
            System.out.print(player);
            playerTurn = scanner.next();
        }

        return playerTurn;
    }

    private boolean checkPlayerTurn(String playerTurn){
        for (String proposition : choice) {
            if (playerTurn.equals(proposition)) {
                return true;
            }
        }
        return false;
    }


    private void printPoint(String name){

        int point;
        if (name.equals(this.getNpc().getName())){
            point = NPCPoint;
        } else {
            point = playerPoint;
        }

        System.out.println("- " +
                name +
                " : " +
                point +
                " point(s).");
    }

    private void checkWinner(String playerTurn, int NPCTurn){
        NPC npc = this.getNpc();

        if (playerTurn.equals(choice[NPCTurn])) {
            npc.dialog("Draw, I will get you in the next round !");
        } else if (playerTurn.equals(choice[(NPCTurn+1)%3])){
            npc.dialog("Bruh, I lose");
            playerPoint++;
        } else {
            npc.dialog("I win, I'm juste the boss !");
            NPCPoint++;
        }
    }

}
