package place.game;

import character.NPC;
import character.Player;
import place.Game;

import java.util.Random;
import java.util.Scanner;

public class GlassBridge extends Game {

    GlassBridge() {
        super("Glasse bridge", "Le but est de traverser le pont sans tomber sur un verre fragile.",
                new NPC("RPC NPC"));
    }

    @Override
    public void play(Player player) {

        int longueurPont = 10;
        int progression = 0;
        boolean gameWin = false;
        boolean[][] pont = new boolean[longueurPont][2];
        // Pour savoir si le retour chariot est /r ou /n (windows ou linux)
        String newLine = System.lineSeparator();

        // Initialisation du pont
        boolean pontInitialiser = false;

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
        System.out.println("Affichage du pont :");
        bridgePrint(pont, longueurPont);
        */

        // Lancement du jeu
        while (progression < longueurPont) {
            String choixUtilisateur = "";

            if (progression != 0) {
                System.out.println("Rapel du chemin parcouru :");
                bridgePrint(pont, progression);
            }

            while (!choixUtilisateur.equalsIgnoreCase("l") && !choixUtilisateur.equalsIgnoreCase("r")) {
                Scanner scanner = new Scanner(System.in);

                System.out.println(newLine + "Veuillez choisir si vous voulez avancer sur la plateforme de gauche ou de droite.");
                System.out.print("Pour cela, tapez l (left) ou r (right) : ");

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
            System.out.println(newLine + "Vous avez gagné !");
        }
        else {
            System.out.println(newLine + "Perdu");
        }
    }

    /**
     * @param pont Pont à afficher : de type [x][y] avec y compris dans [0;1]
     * @param longueurPont Longueur du pont à afficher
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
