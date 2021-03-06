package squid.place.game;

import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.item.Empty;
import squid.place.Game;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GlassBridge extends Game {

    public GlassBridge() {
        super("GlassBridge", "The object of the game is to cross the bridge without falling on fragile glass.",
                new NPC("GB_NPC",new Empty()), genExit2Ways(new HashMap<>(),"GlassBridge","MainRoom"));
    }

    @Override
    public void removePlayer() {

    }

    @Override
    public void play(Player player) {
        int longueurPont = 5;
        int progression = 0;
        boolean gameWin = false;
        boolean[][] pont = new boolean[longueurPont][2];
        // Savoir si le retour chariot est /r ou /n (windows ou linux)
        String newLine = System.lineSeparator();

        // Initialisation du pont
        boolean pontInitialiser = false;

        System.out.println("\n--- Game launched ---\n");

        while (!pontInitialiser) {
            for (int compteur = 0 ; compteur < longueurPont ; compteur++) {
                boolean leftBox;
                Random booleanAleatory = new Random();
                leftBox = booleanAleatory.nextBoolean();

                pont[compteur][0] = leftBox;
                pont[compteur][1] = !leftBox;

                if (compteur == longueurPont - 1) {
                    pontInitialiser = true;
                }
            }
        }

        /* Pour tester
        System.out.println("Affichage complet du pont :");
        bridgePrint(pont, longueurPont);
        */

        // Lancement du jeu
        while (progression < longueurPont) {
            String choixUtilisateur = "";

            if (progression != 0) {
                System.out.println("Reminder of the distance traveled :");
                bridgePrint(pont, progression);
            }

            while (!choixUtilisateur.equalsIgnoreCase("l") && !choixUtilisateur.equalsIgnoreCase("r")) {
                Scanner scanner = new Scanner(System.in);

                System.out.println(newLine + "Please choose whether you want to jump on the left or right platform.");
                System.out.print("To do this, type l (left) or r (right) : ");

                choixUtilisateur = scanner.nextLine();
            }

            if ((choixUtilisateur.equalsIgnoreCase("l") && pont[progression][0] == true)
                    || (choixUtilisateur.equalsIgnoreCase("r") && pont[progression][1] == true)){
                progression++;
                if (progression == longueurPont) {
                    gameWin = true;
                }
            }
            else {
                progression = longueurPont;
                gameWin = false;
            }
        }

        if (gameWin) {
            winner();
            player.isInGame = false;
        }
        else {
            lose(player);
        }


    }

    /**
     * @param pont Pont ?? afficher : de type [x][y] avec y compris dans [0;1]
     * @param longueurPont Longueur du pont ?? afficher
     */
    public void bridgePrint(boolean[][] pont, int longueurPont) {
        for (int compteur = 0 ; compteur < longueurPont ; compteur++) {
            if (pont[compteur][0]) {
                System.out.print("[OK]  ");
            }
            else {
                System.out.print("[  ]  ");
            }

            if (pont[compteur][1]) {
                System.out.println("[OK]");
            }
            else {
                System.out.println("[  ]");
            }
        }
    }
}
