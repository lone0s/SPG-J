package squid.place.game.TicTacToe;

public class BoardGame {
    private Box[][] BoardGame = new Box[3][3];

    /**
     * Créer le plateau de jeu du morpion
     */
    BoardGame() {
        this.BoardGame = initialization();
    }

    /**
     * @return Plateau de jeu avec toutes les cases = "null"
     */
    private Box[][] initialization() {
        Box[][] boardGame = this.getBoardGame();

        for (int ligne = 0 ; ligne < 3 ; ligne++) {
            for (int colonne = 0 ; colonne < 3 ; colonne++) {
                boardGame[ligne][colonne] = new Box();
            }
        }

        return boardGame;
    }

    /**
     * @return Plateau de jeu
     */
    public Box[][] getBoardGame() {
        return this.BoardGame;
    }
}
