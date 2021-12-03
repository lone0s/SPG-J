package squid.exit;


import squid.place.Place;
import java.util.HashMap;
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
            return ("[" + this.Source + "] --> [" + this.Destination + "]");
    }
    /*
     *  Fonction retournant les Places accesssibles à un jouueur
     */
    public static void printAllowedExits (HashMap<String,Exit> exits, Place playerLoc) {
        Set<String> myKeys = exits.keySet();
        myKeys.remove(playerLoc.getName());
        System.out.println(myKeys);
    }
}
