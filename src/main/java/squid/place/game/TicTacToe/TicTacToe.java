package squid.place.game.TicTacToe;

import squid.character.NPC;
import squid.character.Player;
import squid.exit.Exit;
import squid.place.Game;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends Game {
    public TicTacToe() {
        super("Crabs", "Description du jeu",
                new NPC("GB_NPC"),
                genExit2Ways(new HashMap<String,Exit>(),"Crabs","Main Room"))
        ;
    }

    @Override
    public void removePlayer() {
        int nbPlayer = getNbPlayer();
        Random nbAleatory = new Random();
        nbPlayer = 25 + nbAleatory.nextInt(nbPlayer/2 - 25 + 1);
        setNbPlayer(nbPlayer);
        System.out.println("Il reste maintenant " + nbPlayer + " players !");
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
        while (winPlay(boardGame, symbolPlayer, symbolNPC).getSymbol().equals("NULL") && numberPossibleMoves(boardGame) != 0) {
            System.out.println("Nombre possible = " + numberPossibleMoves(boardGame));
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
        if (winPlay(boardGame, symbolPlayer, symbolNPC).getSymbol().equals(symbolPlayer.getSymbol())) {
            this.removePlayer();
            winner();
        }
        else if (winPlay(boardGame, symbolPlayer, symbolNPC).getSymbol().equals(symbolNPC.getSymbol())) {
            lose(player);
        }
        else {
            System.out.println("Partie null.");
        }
        scanner.nextLine();
        System.out.println("\n--- Game finished ---\n");
    }

    /**
     * @return True if the player starts first
     */
    private boolean playerStartFirst() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /**
     * @param numberBox Number corresponding to the square of the Tic Tac Toe game board
     * @return Pair of integers corresponding to the square of the Tic Tac Toe game board
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

    /**
     * @param symbolPlayer Player symbol
     * @return NPC symbol
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
     * @param boardGame Tic Tac Toe game board
     * @return True if it is possible to place a pawn (we don't care if the game is won)
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
     * @param boardGame Tic Tac Toe game board
     * @return Number of possible movements
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

    /**
     * @param boardGame Tic Tac Toe game board
     * @param symbolPlayer Player symbol
     * @param symbolNPC NPC symbol
     * @return
     */
    private Symbol winPlay(BoardGame boardGame, Symbol symbolPlayer, Symbol symbolNPC) {

        // [X][X][X]     [ ][ ][ ]     [ ][ ][ ]
        // [ ][ ][ ]     [X][X][X]     [ ][ ][ ]
        // [ ][ ][ ]     [ ][ ][ ]     [X][X][X]
        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            if (boardGame.getBoardGame()[ligne][0].getPlayer().getSymbol().equals(boardGame.getBoardGame()[ligne][1].getPlayer().getSymbol())
                    && boardGame.getBoardGame()[ligne][1].getPlayer().getSymbol().equals(boardGame.getBoardGame()[ligne][2].getPlayer().getSymbol())) {
                return boardGame.getBoardGame()[ligne][2].getPlayer();
            }
        }

        // [X][ ][ ]     [ ][X][ ]     [ ][ ][X]
        // [X][ ][ ]     [ ][X][ ]     [ ][ ][X]
        // [X][ ][ ]     [ ][X][ ]     [ ][ ][X]
        for (int colonne = 0 ; colonne < 3 ; colonne++) {
            if (boardGame.getBoardGame()[0][colonne].getPlayer().getSymbol().equals(boardGame.getBoardGame()[1][colonne].getPlayer().getSymbol())
                    && boardGame.getBoardGame()[1][colonne].getPlayer().getSymbol().equals(boardGame.getBoardGame()[2][colonne].getPlayer().getSymbol())) {
                return boardGame.getBoardGame()[2][colonne].getPlayer();
            }
        }

        // [X][ ][ ]
        // [ ][X][ ]
        // [ ][ ][X]
        if (boardGame.getBoardGame()[0][0].getPlayer().getSymbol().equals(boardGame.getBoardGame()[1][1].getPlayer().getSymbol())
                && boardGame.getBoardGame()[1][1].getPlayer().getSymbol().equals(boardGame.getBoardGame()[2][2].getPlayer().getSymbol())) {
            return boardGame.getBoardGame()[1][1].getPlayer();
        }

        // [ ][ ][X]
        // [ ][X][ ]
        // [X][ ][ ]
        else if (boardGame.getBoardGame()[0][2].getPlayer().getSymbol().equals(boardGame.getBoardGame()[1][1].getPlayer().getSymbol())
                && boardGame.getBoardGame()[1][1].getPlayer().getSymbol().equals(boardGame.getBoardGame()[2][0].getPlayer().getSymbol())) {
            return boardGame.getBoardGame()[1][1].getPlayer();
        }

        else {
            return new Symbol("NULL");
        }
    }

    /**
     * @param boardGame Tic Tac Toe game board
     * @param symbolPlayer Player symbol
     * @param symbolNPC NPC symbol
     * @return Turns the current state of the game into a "point"
     */
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


    /**
     * @param boardGame Tic Tac Toe game board
     * @param depth tree travel depth
     * @param isMax Indicates whether we are looking for the player or the computer
     * @param symbolPlayer Player symbol
     * @param symbolNPC NPC symbol
     * @return
     */
    private int minimax(BoardGame boardGame, int depth, boolean isMax, Symbol symbolPlayer, Symbol symbolNPC) {
        int score = winPlayToInt(boardGame, symbolNPC, symbolPlayer);

        // If Maximizer has won the game return his/her evaluated score If Minimizer has won the game return his/her evaluated score
        if (score == 10 || score == -10) {
            return score;
        }

        // If there are no more moves and no winner then it is a tie
        if (!(movementIsPossiblePawn(boardGame))) {
            return 0;
        }

        // If this maximizer's move
        if (isMax) {
            int bestScore = -1000;

            // Traverse all cells
            for (int ligne = 0; ligne < 3; ligne++) {
                for (int colonne = 0; colonne < 3; colonne++) {
                    // Check if cell is empty
                    if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                        // Make the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolNPC);

                        // Call minimax recursively and choose the maximum value
                        bestScore = Math.max(bestScore, minimax(boardGame, depth + 1, !isMax, symbolPlayer, symbolNPC));

                        // Undo the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(new Symbol("NULL"));
                    }
                }
            }
            return bestScore;
        }
        else {
            int best = 1000;

            // Traverse all cells
            for (int ligne = 0 ; ligne < 3 ; ligne++) {
                for (int colonne = 0 ; colonne < 3 ; colonne++) {
                    if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {

                        boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolPlayer);

                        best = Math.min(best, minimax(boardGame, depth + 1, !isMax, symbolPlayer, symbolNPC));

                        boardGame.getBoardGame()[ligne][colonne].setPlayer(new Symbol("NULL"));
                    }
                }
            }
            return best;
        }
    }

    /**
     * @param boardGame Tic Tac Toe game board
     * @param symbolNPC NPC symbol
     * @param symbolPlayer Player symbol
     * @return Better move with more chance of the computer winning
     */
    IntPair findBestMove(BoardGame boardGame, Symbol symbolNPC, Symbol symbolPlayer) {
        int bestScore = -1000;
        IntPair intPair = new IntPair(-1, -1);

        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            for (int colonne = 0 ; colonne < 3 ; colonne++) {
                // Check if cell is empty
                if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                    // Make the move
                    boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolNPC);

                    int moveVal = minimax(boardGame, 0, false, symbolPlayer, symbolNPC);

                    // Anule le coup
                    boardGame.getBoardGame()[ligne][colonne].setPlayer(new Symbol("NULL"));

                    if (moveVal > bestScore) {
                        intPair.setNumber1(ligne);
                        intPair.setNumber2(colonne);
                        bestScore = moveVal;
                    }
                }
            }
        }
        return intPair;
    }

    /**
     * @param boardGame Tic Tac Toe game board
     * @return An integer pair table corresponding to the boxes with the possibility of playing
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

    /**
     * @param boardGame Tic Tac Toe game board
     * @param intPair integer couple in order to check the validity of this move
     * @return True if the move is valid
     */
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
