package squid.item;

import squid.character.Player;
import squid.place.Place;

import java.util.Random;

public class Knife extends Item {
    private int NbKill;

    private static final int MIN_KILL = 1;
    private static final int MAX_KILL = 5;

    /**
     * Ce constructeur créer un couteaux avec une explication pour l'utiliser.
     */
    public Knife() {
        super("Couteaux", "Ce couteaux peut être utiliser pour tuer un nombre aléatoire de personnes.");
    }

    /**
     * Est appelée lors de la création du couteaux => Indique combien de personne sont tuées par le couteaux
     */
    public void setRandomKill(Place place) {
        Random nbAleatory = new Random();
        NbKill = MIN_KILL + nbAleatory.nextInt(MAX_KILL - MIN_KILL + 1);
        place.setNbPlayer(place.getNbPlayer() - NbKill);
    }

    /**
     * @return Nombre de personne tuées lors de l'utilisation du couteaux
     */
    public int getRandomKill() {
        return this.NbKill;
    }

    @Override
    public void use(Player player) {
        player.removeItem(this);
    }

}
