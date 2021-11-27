package squid.place.game.TicTacToe;

public class Box {
    /**
     * Contient le nom du joueur ou NPC si présent, sinon contient la chapine de caractère "null"
     */
    private String player;

    Box() {
        this.player = "null";
    }

    /**
     * @return Un joueur est présent ou non
     */
    public boolean isEmpty() {
        return this.player == null;
    }

    /**
     * @return Retourne le nom du joueur présent ou NULL
     */
    public String getPlayer() {
        return this.player;
    }

    /**
     * @param string Indique le nom du joueur/NPC présent dans la case
     */
    public void setPlayer(String string) {
        this.player = string;
    }

    /**
     * Affichage de la case : contient le nom du joueur
     */
    public void print() {
        System.out.print("[ " + this.getPlayer() + " ]");
    }
}
