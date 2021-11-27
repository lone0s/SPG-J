package squid.place.game.TicTacToe;

import squid.character.NPC;
import squid.character.Player;
import squid.place.Game;

import java.util.Random;

public class TicTacToe extends Game {
    public TicTacToe() {
        super("Crabs", "Description du jeu",
                new NPC("GB_NPC"));
    }

    @Override
    public void play(Player player) {
        Random random = new Random();
        boolean computerStarts = random.nextBoolean();

        BoardGame boardGame = new BoardGame();
        Symbol symbolPlayer = new Symbol();

        System.out.println("Votre symbole est : " + symbolPlayer.getSymbol());





    }
/*
    public String pawnChoice() {

    }*/
}
