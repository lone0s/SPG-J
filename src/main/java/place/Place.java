package place;

import character.Character;
import character.NPC;
import item.Item;
import java.util.List;
import java.util.Map;

public abstract class Place {
    private String Name;                    //@Param Nom            ==> Renvoie nom de la pièce
    private String Description;             //@Param Description    ==> Renvoir description de la pièce
    private final Map<String,Exit> Exits;
    private final Character NPC;


    public Place(String placeName, String placeDescription, Map<String,Exit> myExits, Character myNPC) {
        this.Name = placeName;
        this.Description = placeDescription;
        this.Exit = myExits;
        this.NPC = myNPC;
    }

    public void useExit(String Exit){} ;
    //public static List<Place> genAllPlaces(){} ;

}


