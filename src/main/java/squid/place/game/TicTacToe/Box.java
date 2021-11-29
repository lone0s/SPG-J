package squid.place.game.TicTacToe;

public class Box {
    /**
     * Contient le nom du joueur ou NPC si présent, sinon contient la chapine de caractère "NULL"
     */
    private Symbol player;

    Box() {
        this.player = new Symbol("NULL");
    }

    /**
     * @return Retourne le nom du joueur présent ou NULL
     */
    public Symbol getPlayer() {
        return this.player;
    }

    /**
     * @param symbol Indique le nom du joueur/NPC présent dans la case
     */
    public void setPlayer(Symbol symbol) {
        this.player = symbol;
    }

    /**
     * Affichage de la case : contient le symbole du joueur
     */
    public void printBox() {
        if (!(this.getPlayer().getSymbol().equals("NULL"))) {
            System.out.print("[ " + this.getPlayer().getSymbol() + " ]");
        }
        else {
            System.out.print("[   ]");
        }
    }
}
