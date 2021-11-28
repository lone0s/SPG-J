package squid.place.game.TicTacToe;

import java.util.Scanner;

public class Symbol {
    private String Symbol;

    /**
     * Choix du symbole du joueur
     */
    Symbol() {
        Scanner scanner = new Scanner(System.in);
        String symbol = "";
        boolean symbolValid = false;

        while (!symbolValid) {
            System.out.print("Please choose your symbol (X or O) : ");

            if (scanner.hasNext()) {
                symbol = scanner.next();
            }
            scanner.nextLine();
            if (checkValiditySymbol(symbol)) {
                this.Symbol = symbol;
                symbolValid = true;
            }
        }
    }

    /**
     * @param symbol Creation du symbole de l'ordinateur
     */
    Symbol(String symbol) {
        if (checkValiditySymbol(symbol) || symbol.equals("NULL") || symbol.equals("AUTRE")) {
            this.Symbol = symbol;
        }
        else {
            System.out.println("Erreur lors du choix du symbole de TicTacToe de l'ordinateur : le symbole n'est pas valide.");
            System.exit(-1);
        }
    }

    /**
     * @param symbol Symbole a vérifier
     * @return True si le symbole est valide
     */
    private boolean checkValiditySymbol(String symbol) {
        return symbol.equals("X") || symbol.equals("O");
    }

    /**
     * @return Symbole associé ("X" ou "O")
     */
    public String getSymbol() {
        return this.Symbol;
    }
}
