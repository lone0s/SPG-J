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
        super("TicTacToe", "Description du jeu",
                new NPC("GB_NPC"),
                genExit2Ways(new HashMap<>(),"TicTacToe","MainRoom"))
        ;
    }

    @Override
    public void removePlayer() {
        int nbPlayer = getNbPlayer() / 2;
        setNbPlayer(nbPlayer);
        System.out.println("Il reste maintenant " + nbPlayer + " players !");
    }

    @Override
    public void play(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean playerStart = false;//playerStartFirst();

        // Creation of the game board
        BoardGame boardGame = new BoardGame();

        // Definition of player symbol => "X" or "O"
        Symbol symbolPlayer = new Symbol();
        // We give the remaining symbol to the computer
        Symbol symbolNPC = symbolNPC(symbolPlayer);

        // Game grid numbering system display
        this.getNpc().dialog(this.printExplanationsGameGrid());

        // As long as the game is not over
        while (winPlay(boardGame).getSymbol().equals("NULL") && numberPossibleMoves(boardGame) != 0) {
            // If it's up to the player to play
            if (playerStart) {
                boolean playOK = false;
                IntPair intPair = new IntPair(-1, -1);

                boardGame.printBoardGame();

                while (!playOK) {
                    int nombre = 0;

                    while (nombre <= 0 || nombre > 9) {
                        this.getNpc().dialog("Veuillez choisir la case :");

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
            // If it is for the computer to play
            else {
                IntPair intPair = findBestMove(boardGame, symbolNPC, symbolPlayer);
                boardGame.getBoardGame()[intPair.getNumber1()][intPair.getNumber2()].setPlayer(symbolNPC);
                playerStart = true;
            }
        }
        // If the player won
        if (winPlay(boardGame).getSymbol().equals(symbolPlayer.getSymbol())) {
            this.removePlayer();
            winner();
        }
        // If the computer won
        else if (winPlay(boardGame).getSymbol().equals(symbolNPC.getSymbol())) {
            boardGame.printBoardGame();
            lose(player);
        }
        // Otherwise it's a draw
        else {
            System.out.println("Partie null.");
        }
        scanner.nextLine();
        System.out.println("\n--- Game finished ---\n");
    }

    /**
     * @return print explanation on the numbering of the game grid
     */
    private String printExplanationsGameGrid() {
        // Find out if the carriage return is /r or /n (windows or linux)
        String newLine = System.lineSeparator();

        return "Each square of the game grid is numbered such as :" + newLine
                + "[1]  [2]  [3]" + newLine
                + "[4]  [5]  [6]" + newLine
                + "[7]  [8]  [9]";
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
     * @return The winner of the game or "NULL"
     */
    private Symbol winPlay(BoardGame boardGame) {

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
     * @param symbolNPC NPC symbol
     * @return Turns the current state of the game into a "point"
     */
    private int winPlayToInt(BoardGame boardGame, Symbol symbolNPC) {
        Symbol symbol = winPlay(boardGame);

        if (symbol.getSymbol().equals("NULL")) {
            return 0;
        }
        else if (symbol.getSymbol().equals(symbolNPC.getSymbol())) {
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
     * @return Score of the box
     */
    private int minimax(BoardGame boardGame, int depth, boolean isMax, Symbol symbolPlayer, Symbol symbolNPC) {
        int score = winPlayToInt(boardGame, symbolNPC);

        // If Maximizer has won the game return or if Minimizer has won => Return the game his evaluated score
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

            // Traverse all boxs
            for (int ligne = 0; ligne < 3; ligne++) {
                for (int colonne = 0; colonne < 3; colonne++) {
                    // Check if box is empty
                    if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {
                        // Make the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolNPC);

                        // Call minimax recursively and choose the maximum value
                        bestScore = Math.max(bestScore, minimax(boardGame, depth + 1, false, symbolPlayer, symbolNPC));

                        // Undo the move
                        boardGame.getBoardGame()[ligne][colonne].setPlayer(new Symbol("NULL"));
                    }
                }
            }
            return bestScore;
        }
        else {
            int best = 1000;

            // It is the same algorithm as the previous one, but this time we recursively call the minimum value
            for (int ligne = 0 ; ligne < 3 ; ligne++) {
                for (int colonne = 0 ; colonne < 3 ; colonne++) {
                    if (boardGame.getBoardGame()[ligne][colonne].getPlayer().getSymbol().equals("NULL")) {

                        boardGame.getBoardGame()[ligne][colonne].setPlayer(symbolPlayer);

                        best = Math.min(best, minimax(boardGame, depth + 1, true, symbolPlayer, symbolNPC));

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

                    // Undo the move
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