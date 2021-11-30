package squid.place;

import squid.character.NPC;
import squid.exit.Exit;
import squid.place.game.FindNumber;
import squid.place.game.GlassBridge;
import squid.place.game.GuessMyWord.GuessMyWord;
import squid.place.game.MarblesGame;
import squid.place.game.RockPapersScissors;
import squid.place.game.TicTacToe.TicTacToe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Place {

    private int nbPlayer = 456;
    /**
     * Nom de la pièce
     */
    private final String name;
    /**
     * Description de la pièce
     */
    private final String description;
    private final HashMap<String,Exit> exits;
    private final NPC npc;


    public Place(String placeName, String placeDescription, NPC myNPC,HashMap<String,Exit> Exits) {
        this.name = placeName;
        this.description = placeDescription;
        this.npc = myNPC;
        this.exits = new HashMap<>(Exits);
    }

    /**
     * @return Nom de la pièce
     */
    public String getName() {
        return this.name;
    }

    public void getDescription(){
        System.out.println(this.description);
    }

    public NPC getNpc() {
        return this.npc;
    }

    public int getNbPlayer(){
        return this.nbPlayer;
    }

    public void setNbPlayer(int nbPlayer){
        this.nbPlayer = nbPlayer;
    }

    public static List<Place> genAllPlaces(){

        List<Place> placeList = new ArrayList<>();
        NPC mainnpc = new NPC("Triangle Guard");
        HashMap<String,Exit> hubExits = new HashMap<>();

        // Exits Hub

        genExit2Ways(hubExits,"MainRoom","RockPaperScissors");
        genExit2Ways(hubExits,"MainRoom","GlassBridge");
        genExit2Ways(hubExits, "MainRoom","FindNumber");
        genExit2Ways(hubExits,"MainRoom","TicTacToe");
        genExit2Ways(hubExits,"MainRoom","MarblesGame");
        genExit2Ways(hubExits,"MainRoom","GuessMyWord");

        // Hub

        placeList.add(new Place("MainRoom",
                "[*] This is the principal place of the game",
                mainnpc, hubExits));
        placeList.add(new FindNumber());
        placeList.add(new RockPapersScissors());
        placeList.add(new GlassBridge());
        placeList.add(new TicTacToe());
        placeList.add(new MarblesGame());
        placeList.add(new GuessMyWord());
        return placeList;
    }

    public static Place findPlace (String placeName, List<Place> map) {
        int indice = 0;
        for(int i = 0; i < map.size(); i++) {
            if (map.get(i).getName().equals(placeName)) {
                indice = i;
            }
        }
        return map.get(indice);
    }
    public static boolean placeExists (String placeName, HashMap<String,Exit> exits) {
        return (exits.containsKey(placeName));
    }

    public HashMap<String,Exit> getExits(){
        return this.exits;
    }

    public Collection<Exit> allExits() {
        return this.exits.values();
    }



    //public static boolean hasExit(Collection<Exit> mapExits,String mapName) {}
    public static HashMap<String,Exit> genExit2Ways(HashMap<String,Exit> Exits,String mapSrc, String mapDest) {
        Exit Src2Dest = new Exit(mapSrc,mapDest);
        Exit Dest2Src = new Exit(mapDest,mapSrc);
        Exits.put(Src2Dest.getDest(), Src2Dest);
        Exits.put(Dest2Src.getDest(), Dest2Src);
        return Exits;
    }




}


