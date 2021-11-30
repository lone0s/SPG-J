package squid.exit;


import squid.character.Player;
import squid.place.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Exit {
    /**
     * Nom de la pièce contenant la sortie
     */
    private String Source;
    /**
     * Nom de la pièce de sortie
     */
    private String Destination;

    public Exit(String mapSrc, String mapDst) {
        this.Source = mapSrc;
        this.Destination = mapDst;
    }

    public String getSrc() {
        return this.Source;
    }

    public String getDest() {
        return this.Destination;
    }

    @Override
    public String toString() {
        //if(!this.Destination.equals(this.Source)) {
            return ("[" + this.Source + "] --> [" + this.Destination + "]");
        //}
    }

    public static void printAllowedExits (HashMap<String,Exit> exits, Place playerLoc) {
        Set<String> myKeys = exits.keySet();
        int cpt = 0;
        myKeys.remove(playerLoc.getName());
        System.out.println(myKeys);
    }
}
