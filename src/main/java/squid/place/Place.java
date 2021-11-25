package squid.place;

import squid.character.NPC;
import squid.place.game.FindNumber;
import squid.place.game.GlassBridge;
import squid.place.game.RockPapersScissors;

import java.util.ArrayList;
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
    //private final List<Exit> exitList;
    private final NPC npc;


    public Place(String placeName, String placeDescription, NPC myNPC) {
        this.name = placeName;
        this.description = placeDescription;
        this.npc = myNPC;
        //this.exitList = new ArrayList<>();
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

   // public List<Exit> getExitList() {
   //    return this.exitList;
   // }

    public void useExit(String Exit){};


    public static List<Place> genAllPlaces(){
        List<Place> placeList = new ArrayList<>();

        NPC mainnpc = new NPC("Triangle Guard");


        // Hub
        placeList.add(new Place("Main room",
                "[*] This is the principal place of the game",
                mainnpc));

        placeList.add(new FindNumber());
        placeList.add(new RockPapersScissors());
        placeList.add(new GlassBridge());

        return placeList;
    }



}


