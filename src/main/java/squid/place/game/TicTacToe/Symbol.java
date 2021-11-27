package squid.place.game.TicTacToe;

import java.util.Scanner;

public class Symbol {
    private final String Symbol;

    /**
     * Choix du symbole du joueur
     */
    Symbol() {
        Scanner scanner = new Scanner(System.in);
        String symbol = "";

        while (!checkValiditySymbol(symbol)) {
            System.out.print("Please choose your symbol (X or O) : ");

            if (scanner.hasNext()) {
                symbol = scanner.next();
            }
            scanner.nextLine();
        }

        this.Symbol = symbol;
    }

    /**
     * @param symbol Symbole à associer à l'ordinateur
     */
    Symbol(String symbol) {
        if (checkValiditySymbol(symbol)) {
            this.Symbol = symbol;
        }
        else {

        }
    }

    private boolean checkValiditySymbol(String symbol) {
        return symbol.equals("X") || symbol.equals("O");
    }

    public String getSymbol() {
        return this.Symbol;
    }
}
