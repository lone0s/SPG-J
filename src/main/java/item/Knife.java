package item;

import character.Player;

import java.util.Random;

public class Knife extends Item{

    private static final int MIN_KILL = 1;
    private static final int MAX_KILL = 5;

    public Knife(String name, String description) {
        super(name, description);
    }


    public int randomKill(){

        Random nbAleatory = new Random();

        return MAX_KILL + nbAleatory.nextInt(MAX_KILL - MIN_KILL);
    }

    @Override
    public void use(Player player) {




    }

}
