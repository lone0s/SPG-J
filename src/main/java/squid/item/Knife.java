package squid.item;

import squid.character.Player;
import squid.place.Place;

import java.util.List;
import java.util.Random;

public class Knife extends Item {
    private int NbKill;

    private static final int MIN_KILL = 1;
    private static final int MAX_KILL = 5;

    /**
     * This builder create a knives with an explanation.
     */
    public Knife() {
        super("Knife", "Ce couteaux peut être utiliser pour tuer un nombre aléatoire de personnes.");
    }

    /**
     * Is called when the knife is created => Indicates how many people are killed by the knife
     */
    public void setRandomKill(Place place) {
        Random nbAleatory = new Random();
        NbKill = MIN_KILL + nbAleatory.nextInt(MAX_KILL - MIN_KILL + 1);
    }

    /**
     * @return Number of people killed while using the knife
     */
    public int getRandomKill() {
        return this.NbKill;
    }

    /**
     * @param player player of the game
     */
    @Override
    public void use(Player player) {
        Place place = player.getPlace();

        setRandomKill(place);
        place.setNbPlayer(place.getNbPlayer() - NbKill);
        System.out.println("[*] You just killed " + getRandomKill() + " people.");

        List<Item> items = player.getItems();
        for (int compteur = 0 ; compteur < items.size() ; compteur++) {
            if (items.get(compteur).getName().equalsIgnoreCase("Knife")) {
                player.removeItem(items.get(compteur));
                break;
            }
        }
    }

}
