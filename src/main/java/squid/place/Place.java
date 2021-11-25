package squid.place;

import squid.character.NPC;

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
    //public static List<Place> genAllPlaces(){} ;

}


