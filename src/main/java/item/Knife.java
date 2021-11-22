package item;

import character.Player;

import java.util.Random;

public class Knife extends Item {
    private static final String name = "Couteaux";
    private static final String description = "Ce couteaux peut être utiliser pour tuer un nombre aléatoire de personnes.";
    private int NbKill;

    private static final int MIN_KILL = 1;
    private static final int MAX_KILL = 5;

    /**
     * Ce constructeur créer un couteaux avec une explication pour l'utiliser.
     */
    public Knife() {
        super(name, description);
        this.setRandomKill();
    }

    /**
     * Est appelée lors de la création du couteaux => Indique combien de personne sont tuées par le couteaux
     */
    public void setRandomKill() {
        Random nbAleatory = new Random();
        NbKill = nbAleatory.nextInt(MIN_KILL, MAX_KILL);
    }

    /**
     * @return Nombre de personne tuées lors de l'utilisation du couteaux
     */
    public int getRandomKill() {
        return this.NbKill;
    }

    @Override
    public void use(Player player) {
    }

    /**
     * Affichage du couteaux
     */
    @Override
    public void printItem() {
        super.printItem();
    }

}
