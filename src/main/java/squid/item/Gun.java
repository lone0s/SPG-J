package squid.item;

import squid.character.Player;
import squid.place.Place;

import java.util.List;

public class Gun extends Item {
    private final static String name = "Pistolet";
    private final static String description = "Pour utiliser ce pistolet, il faut posséder un chargeur.";

    /**
     * Ce constructeur créer un pistolet avec une explication pour l'utiliser.
     */
    public Gun() {
        super("Gun", "To use the gun, you must first have a mug (charged)");
    }

    @Override
    public void use(Player player) {
        Place place = player.getPlace();
        List<Item> items = player.getItems();

        for (int compteur = 0 ; compteur < items.size() ; compteur++) {
            if (items.get(compteur).getName().equalsIgnoreCase("Mag")) {
                Mag mag = (Mag)items.get(compteur);
                if (mag.getNbAmmo() == -1) {
                    System.out.println("[*] You have to use first your mag.\n");
                    break;
                }
                else {
                    place.setNbPlayer(place.getNbPlayer() - mag.getNbAmmo());
                    System.out.println("[*] You killed " + mag.getNbAmmo() + " people.");
                    player.removeItem(mag);

                    List<Item> nouveauItems = player.getItems();
                    for (int compteur2 = 0 ; compteur2 < nouveauItems.size() ; compteur2++) {
                        if (nouveauItems.get(compteur).getName().equalsIgnoreCase("Gun")) {
                            player.removeItem(nouveauItems.get(compteur2));
                            break;
                        }
                    }
                    break;
                }
            }
            else {
                System.out.println("You cannot use the gun without the mag.");
            }
        }
    }
}
