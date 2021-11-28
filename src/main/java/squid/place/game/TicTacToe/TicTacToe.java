package squid.place.game.TicTacToe;

import squid.character.NPC;
import squid.character.Player;
import squid.place.Game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends Game {
    public TicTacToe() {
        super("Crabs", "Description du jeu",
                new NPC("GB_NPC"));
    }

    @Override
    public void play(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean playerStart = playerStartFirst();

        // Création du plateau de jeu
        BoardGame boardGame = new BoardGame();

        // Définition du symbole du joueur => "X" ou "O"
        Symbol symbolPlayer = new Symbol();
        // On donne le symbole restant à l'ordinateur
        Symbol symbolNPC = symbolNPC(symbolPlayer);

        // Tant que le jeu n'est pas terminé
        while (winPlay(boardGame, symbolPlayer, symbolNPC).getSymbol().equals("NULL")) {
            if (playerStart) {
                boolean playOK = false;
                IntPair intPair = new IntPair(-1, -1);

                boardGame.printBoardGame();

                while (!playOK) {
                    int nombre = 0;

                    while (nombre <= 0 || nombre > 9) {
                        System.out.print("Veuillez choisir la case : ");

                        if (scanner.hasNextInt()) {
                            nombre = scanner.nextInt();
                        }
                        scanner.nextLine();
                    }

                    intPair = numberBoxToIntPair(nombre);
                    playOK = possibleMovesOK(boardGame, intPair);
                }

                boardGame.getBoardGame()[intPair.getNumber1()][intPair.getNumber2()].setPlayer(symbolPlayer);
                playerStart = false;

            }
            else {
                IntPair intPair = findBestMove(boardGame, symbolNPC, symbolPlayer);
                boardGame.getBoardGame()[intPair.getNumber1()][intPair.getNumber2()].setPlayer(symbolNPC);
                playerStart = true;
            }
        }
        if (playerStart) {
            boardGame.printBoardGame();
            lose(player);
        }
        else {
            winner();
        }





    }

    /**
     * @return True si le joueur commence en premier
     */
    private boolean playerStartFirst() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /**
     * @param numberBox Plateau du jeu du morpion
     * @return Couple d'entier  d'indices correspondants à la case
     */
    private IntPair numberBoxToIntPair(int numberBox) {
        IntPair intPair;

        switch (numberBox) {
            case 1 : intPair = new IntPair(0, 0); break;
            case 2 : intPair = new IntPair(0, 1); break;
            case 3 : intPair = new IntPair(0, 2); break;
            case 4 : intPair = new IntPair(1, 0); break;
            case 5 : intPair = new IntPair(1, 1); break;
            case 6 : intPair = new IntPair(1, 2); break;
            case 7 : intPair = new IntPair(2, 0); break;
            case 8 : intPair = new IntPair(2, 1); break;
            default : intPair = new IntPair(2, 2); break;
        }

        return intPair;
    }

    private int intPairToNumberBox(IntPair intPair) {
        int numberBox;

        if (intPair.getNumber1() == 0 && intPair.getNumber2() == 0) {
            numberBox = 1;
        }
        else if (intPair.getNumber1() == 0 && intPair.getNumber2() == 1) {
            numberBox = 2;
        }
        else  if (intPair.getNumber1() == 0 && intPair.getNumber2() == 2) {
            numberBox = 3;
        }
        else  if (intPair.getNumber1() == 1 && intPair.getNumber2() == 0) {
            numberBox = 4;
        }
        else  if (intPair.getNumber1() == 1 && intPair.getNumber2() == 1) {
            numberBox = 5;
        }
        else  if (intPair.getNumber1() == 1 && intPair.getNumber2() == 2) {
            numberBox = 6;
        }
        else  if (intPair.getNumber1() == 2 && intPair.getNumber2() == 0) {
            numberBox = 7;
        }
        else  if (intPair.getNumber1() == 2 && intPair.getNumber2() == 1) {
            numberBox = 8;
        }
        else {
            numberBox = 9;
        }

        return numberBox;
    }

    /**
     * @param symbolPlayer Symbole du joueur
     * @return Symbole du NPC
     */
    private Symbol symbolNPC(Symbol symbolPlayer) {
        Symbol symbolNPC;

        if (symbolPlayer.getSymbol().equals("X")) {
            symbolNPC = new Symbol("O");
        }
        else {
            symbolNPC = new Symbol("X");
        }

        return symbolNPC;
    }

    /**
     * @param boardGame Plateau du jeu du morpion
     * @return True s'il est possible de placer un pion (on ne s'occupe pas si la partie est gagné)
     */
    boolean movementIsPossiblePawn(BoardGame boardGame) {
        boolean movementPossiblePawn = false;

        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            for (int colonne = 0 ; colonne < 3 ; colonne++) {
                if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                    movementPossiblePawn = true;
                    ligne = 3;
                    break;
                }
            }
        }

        return movementPossiblePawn;
    }

    /**
     * @param boardGame Plateau du jeu du morpion
     * @return Nombre de choix possible
     */
    private int numberPossibleMoves(BoardGame boardGame) {
        int numberPossibleMove = 0;

        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            for (int colonne = 0 ; colonne < 3 ; colonne++) {
                if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                    numberPossibleMove++;
                }
            }
        }

        return numberPossibleMove;
    }

    private Symbol winPlay(BoardGame boardGame, Symbol symbolPlayer, Symbol symbolNPC) {

        // [X][X][X]     [ ][ ][ ]     [ ][ ][ ]
        // [ ][ ][ ]     [X][X][X]     [ ][ ][ ]
        // [ ][ ][ ]     [ ][ ][ ]     [X][X][X]
        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            if (boardGame.getBoardGame()[ligne][0].getPlayer().getSymbol().equals(boardGame.getBoardGame()[ligne][1].getPlayer().getSymbol())
                    && boardGame.getBoardGame()[ligne][1].getPlayer().getSymbol().equals(boardGame.getBoardGame()[ligne][2].getPlayer().getSymbol())
                    && !(boardGame.getBoardGame()[ligne][2].getPlayer().getSymbol().equals("NULL"))) {
                if (boardGame.getBoardGame()[ligne][2].getPlayer().getSymbol().equals(symbolPlayer.getSymbol())) {
                    return symbolPlayer;
                }
                else {
                    return symbolNPC;
                }
            }
        }

        // [X][ ][ ]     [ ][X][ ]     [ ][ ][X]
        // [X][ ][ ]     [ ][X][ ]     [ ][ ][X]
        // [X][ ][ ]     [ ][X][ ]     [ ][ ][X]
        for (int colonne = 0 ; colonne < 3 ; colonne++) {
            if (boardGame.getBoardGame()[0][colonne].getPlayer().getSymbol().equals(boardGame.getBoardGame()[1][colonne].getPlayer().getSymbol())
                    && boardGame.getBoardGame()[1][colonne].getPlayer().getSymbol().equals(boardGame.getBoardGame()[2][colonne].getPlayer().getSymbol())
                    && !(boardGame.getBoardGame()[2][colonne].getPlayer().getSymbol().equals("NULL"))) {
                if (boardGame.getBoardGame()[2][colonne].getPlayer().getSymbol().equals(symbolPlayer.getSymbol())) {
                    return symbolPlayer;
                }
                else {
                    return symbolNPC;
                }
            }
        }

        // [X][ ][ ]
        // [ ][X][ ]
        // [ ][ ][X]
        if (boardGame.getBoardGame()[0][0].getPlayer().getSymbol().equals(boardGame.getBoardGame()[1][1].getPlayer().getSymbol())
                && boardGame.getBoardGame()[1][1].getPlayer().getSymbol().equals(boardGame.getBoardGame()[2][2].getPlayer().getSymbol())
                && !(boardGame.getBoardGame()[2][2].getPlayer().getSymbol().equals("NULL"))) {
            if (boardGame.getBoardGame()[2][2].getPlayer().getSymbol().equals(symbolPlayer.getSymbol())) {
                return symbolPlayer;
            }
            else {
                return symbolNPC;
            }
        }

        // [ ][ ][X]
        // [ ][X][ ]
        // [X][ ][ ]
        else if (boardGame.getBoardGame()[0][2].getPlayer().getSymbol().equals(boardGame.getBoardGame()[1][1].getPlayer().getSymbol())
                && boardGame.getBoardGame()[1][1].getPlayer().getSymbol().equals(boardGame.getBoardGame()[2][0].getPlayer().getSymbol())
                && !(boardGame.getBoardGame()[2][0].getPlayer().getSymbol().equals("NULL"))) {
            if (boardGame.getBoardGame()[2][0].getPlayer().getSymbol().equals(symbolPlayer.getSymbol())) {
                return symbolPlayer;
            }
            else {
                return symbolNPC;
            }
        }

        else {
            return new Symbol("NULL");
        }
    }

    private int winPlayToInt(BoardGame boardGame, Symbol symbolPlayer, Symbol symbolNPC) {
        Symbol symbol = winPlay(boardGame, symbolPlayer, symbolNPC);

        if (symbol.getSymbol().equals("NULL")) {
            return 0;
        }
        else if (symbol.getSymbol().equals(symbolPlayer.getSymbol())) {
            return 10;
        }
        else {
            return -10;
        }
    }


    private int minimax(BoardGame boardGame, int depth, boolean isMax, Symbol symbolNPC, Symbol symbolPlayer) {
        int score = winPlayToInt(boardGame, symbolNPC, symbolPlayer);

        // If Maximizer has won the game return his/her evaluated score
        // If Minimizer has won the game return his/her evaluated score
        if (score == 10 || score == -10) {
            return score;
        }

        // If there are no more moves and no winner then it is a tie
        if (!(movementIsPossiblePawn(boardGame))) {
            return 0;
        }

        // If this maximizer's move
        if (isMax) {
            int best = -1000;

            // Traverse all cells
            for (int ligne = 0; ligne < 3; ligne++) {
                for (int colonne = 0; colonne < 3; colonne++) {
                    // Check if cell is empty
                    if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                        // Make the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolNPC);

                        // Call minimax recursively and choose the maximum value
                        best = Math.max(best, minimax(boardGame, depth + 1, !isMax, symbolNPC, symbolPlayer));

                        // Undo the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(new Symbol("NULL"));
                    }
                }
            }
            return best;
        }
        else {
            int best = 1000;

            // Traverse all cells
            for (int ligne = 0 ; ligne < 3 ; ligne++) {
                for (int colonne = 0 ; colonne < 3 ; colonne++) {
                    // Check if cell is empty
                    if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                        // Make the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolPlayer);

                        // Call minimax recursively and choose the minimum value
                        best = Math.min(best, minimax(boardGame, depth + 1, !isMax, symbolNPC, symbolPlayer));

                        // Undo the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(new Symbol("NULL"));
                    }
                }
            }
            return best;
        }
    }

    IntPair findBestMove(BoardGame boardGame, Symbol symbolNPC, Symbol symbolPlayer) {
        int bestVal = -1000;
        IntPair intPair = new IntPair(-1, -1);

        // Traverse all cells, evaluate minimax function for all empty cells. And return the cell with optimal value.
        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            for (int colonne = 0 ; colonne < 3 ; colonne++) {
                // Check if cell is empty
                if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                    // Make the move
                    boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolNPC);

                    // compute evaluation function for this move.
                    int moveVal = minimax(boardGame, 0, false, symbolNPC, symbolPlayer);

                    // Undo the move
                    boardGame.getBoardGame()[ligne][colonne].setPlayer(new Symbol("NULL"));

                    // If the value of the current move is more than the best value, then update best
                    if (moveVal > bestVal) {
                        intPair.setNumber1(ligne);
                        intPair.setNumber2(colonne);
                        bestVal = moveVal;
                    }
                }
            }
        }
        return intPair;
    }

    /**
     * @param boardGame Plateau du jeu de morpion
     * @return Un tableau de couple d'entier correspondant aux cases avec possibilitée de jouer
     */
    private IntPair[] possibleMoves(BoardGame boardGame) {
        int numberPossibleMove = numberPossibleMoves(boardGame);
        int indicePossibleMoves = 0;

        IntPair[] possibleMoves = new IntPair[numberPossibleMove];

        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            for (int colonne = 0; colonne < 3; colonne++) {
                if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                    possibleMoves[indicePossibleMoves] = new IntPair(ligne, colonne);
                    indicePossibleMoves++;
                }
            }
        }

        return possibleMoves;
    }

    private boolean possibleMovesOK(BoardGame boardGame, IntPair intPair) {
        int numberPossibleMoves = numberPossibleMoves(boardGame);
        IntPair[] possibleMoves = possibleMoves(boardGame);
        boolean moveFind = false;

        for (int compteur = 0 ; compteur < numberPossibleMoves ; compteur++) {
            if (possibleMoves[compteur].getNumber1() == intPair.getNumber1()
                    && possibleMoves[compteur].getNumber2() == intPair.getNumber2()) {
                moveFind = true;
                break;
            }
        }

        return moveFind;
    }
}
