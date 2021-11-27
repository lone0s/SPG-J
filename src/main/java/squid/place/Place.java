package squid.place;

import squid.character.NPC;
import squid.exit.Exit;
import squid.place.game.FindNumber;
import squid.place.game.GlassBridge;
import squid.place.game.RockPapersScissors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Place {
    /**
     * Nom de la pièce
     */
    private final String name;
    /**
     * Description de la pièce
     */
    private final String description;
    //private final HashMap<String,Exit> exits;
    private final NPC npc;


    public Place(String placeName, String placeDescription, NPC myNPC/*,HashMap<String,Exit> Exits*/) {
        this.name = placeName;
        this.description = placeDescription;
        this.npc = myNPC;
        //this.exits = new HashMap<>(Exits);
    }

    /**
     * @return Nom de la pièce
     */
    public String getName() {
        return this.name;
    }

    public NPC getNpc() {
        return this.npc;
    }

   /* public HashMap<Exit> getExits() {
       return this.exitList;
    }

    public void useExit(String Exit){};
    */


    public static List<Place> genAllPlaces(){
        List<Place> placeList = new ArrayList<>();

        NPC mainnpc = new NPC("Triangle Guard");

        // Creation tous les exits
        //HashMap<String,Exit> hubExits = new HashMap<>();


        /* Exits Hub
        genExit2Ways(hubExits,"Main room","Rock, Papers, Scissors");
        genExit2Ways(hubExits,"Main Room","Glass bridge");
        genExit2Ways(hubExits, "Main Room","Find Number");
        genExit2Ways(hubExits,"Main Room","Crabs");
        */


        // Hub
        placeList.add(new Place("Main room",
                "[*] This is the principal place of the game",
                mainnpc/*, hubExits*/));

        placeList.add(new FindNumber());
        placeList.add(new RockPapersScissors());
        placeList.add(new GlassBridge());

        return placeList;
    }

    public static Place getPlace (String placeName, List<Place> map) {
        Place researchedPlace = new Place(null,null,null/*,null*/);
        for (int cpt = 0 ; cpt < map.size() ; cpt ++) {
            if (map.get(cpt).getName().equals(placeName)) {
                researchedPlace = map.get(cpt);
            }
        }
        return researchedPlace;
    }

    public static HashMap<String,Exit> genExit2Ways(HashMap<String,Exit> Exits,String mapSrc, String mapDest) {
        Exit Src2Dest = new Exit(mapSrc,mapDest);
        Exit Dest2Src = new Exit(mapDest,mapSrc);
        Exits.put(Src2Dest.getDest(), Src2Dest);
        Exits.put(Dest2Src.getDest(), Dest2Src);
        return Exits;
    }


}


