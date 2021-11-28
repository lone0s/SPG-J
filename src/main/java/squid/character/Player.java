package squid.character;

import squid.item.Item;
import squid.place.Game;
import squid.place.Place;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player extends Character{

    static final int DEFAULT_LIVE = 1;
    private Place cur_place;
    private Boolean isLose = false;
    private final List<Item> items;
    private final List<Place> world;
    /**
     * @param name Nom du joueur
     */
    public Player(String name, Place p, List<Place> World) {
        super(name);
        this.cur_place = p;
        this.isLose = false;
        this.items = new ArrayList<>();
        this.world = World;
    }

    public Place getPlace(){
        return this.cur_place;
    }

    public boolean getIsLose(){
        return this.isLose;
    }

    public void setIsLose(){
        this.isLose = true;
    }
    /**
     * @param item Item à rajouté dans la liste d'squid.item du joueur
     */
    public void addItem(Item item) {
        this.items.add(item);
        System.out.println("[*] " + item.getName() +
                " is now in your inventory");
    }

    /**
     * @param item Item à supprimer
     */
    public void removeItem(Item item) {
        this.items.remove(item);
        System.out.println("[*] The item : " +
                item.getName().toLowerCase() +
                " has been removed from your inventory");
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void printInventory(){

        if(this.items.isEmpty()) {
            System.out.println("[*] Your inventory is empty, complete mini-games to get more items!");
        } else {
            this.items.sort(Comparator.comparing(Item::getName));
            System.out.println("[*] In your inventory you have :");

            for (Item item : this.items){
                System.out.println("- " + item.getName());
            }
        }

    }

    public void playGame() {

        if (this.cur_place instanceof Game game) {
            game.play(this);
        } else {
            System.out.println("[*] You are not in a game !");
        }
    }

    public void useExit(String mapDest) {
        if ((this.cur_place.getExits().containsKey(mapDest)) /*&& (!mapDest.equals(this.cur_place.getName()))*/) {
            this.cur_place = Place.findPlace(mapDest,this.world);
        }
    }
}
