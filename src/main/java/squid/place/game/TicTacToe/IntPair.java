package squid.place.game.TicTacToe;

/**
 * Permet de stocker un couple d'entiers
 */
public class IntPair {
    /**
     * Premier nombre du couple
     */
    private int number1;
    /**
     * Deuxième nombre du couple
     */
    private int number2;

    /**
     * @param number1 Premier nombre à stocker dans le couple d'entier
     * @param number2 Deuxième nombre à stocker dans le couple d'entier
     */
    IntPair(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /**
     * @return Accesseur sur number1
     */
    public int getNumber1() {
        return this.number1;
    }

    /**
     * @return Accesseur sur number2
     */
    public int getNumber2() {
        return this.number2;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }
}
