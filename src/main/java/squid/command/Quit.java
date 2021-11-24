package squid.command;

import squid.character.Player;

public class Quit extends Command{

    public Quit(){
        super("quit", "[*] quit : To leave the game");
    }

    @Override
    public void executeCommand(Player player, String[] args){
        System.exit(0);
    }

}
