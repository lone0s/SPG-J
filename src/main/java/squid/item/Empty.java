package squid.item;

import squid.character.Player;

public class Empty extends Item{

    public Empty() {
        super("Empty","No Item");
    }

    @Override
    public void use(Player player) {};
}
