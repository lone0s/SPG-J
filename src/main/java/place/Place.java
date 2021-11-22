package place;

import item.Item;
import java.util.List;
import java.util.Map;

public abstract class Place {
    private final Map<String,Exit> Exit;    //@Param NOM_PIECE,Exit ==> Renvoie pièce principale si dans une pièce mini-jeu et inversement
    private final List<Item> Items;         //@Param Items          ==> Indique les objets présents dans la pièce
    private List<Character> Characters;     //@Param Characters     ==> Indique les joueurs présents dans la pièce

    public Place(Map<String,Exit> myExit, List<Item> myItems, List<Character> myCharacters) {
        this.Exit = myExit;
        this.Items = myItems;
        this.Characters = myCharacters;
    }

    public List<Character> getCharacters() {
        return this.Characters;
    }

    public void interactCharacter(Character myChar) {
        int i = 0;
        while (this.Characters.get(i) != myChar) {
            i++;
        }
        this.Characters.get(i).
    }
}


