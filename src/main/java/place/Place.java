package place;

import character.Character;
import character.NPC;
import item.Item;

import java.util.ArrayList;
import java.util.List;

public class Place {
    private final String name;                    //@Param Nom            ==> Renvoie nom de la pièce
    private final String description;             //@Param Description    ==> Renvoir description de la pièce
    private final List<Exit> exitList;
    private final NPC npc;


    public Place(String placeName, String placeDescription, NPC myNPC) {
        this.name = placeName;
        this.description = placeDescription;
        this.npc = myNPC;
        this.exitList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public NPC getNpc() {
        return this.npc;
    }

    public List<Exit> getExitList() {
        return this.exitList;
    }

    public void useExit(String Exit){} ;
    //public static List<Place> genAllPlaces(){} ;

}



    }
}


