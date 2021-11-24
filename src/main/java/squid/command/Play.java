package squid.command;

import squid.character.Player;

public class Play extends Command{

    public Play() {
        super("play", "[*] play : For play the game if you are in a game room");
    }

    @Override
    public void executeCommand(Player player, String[] args) {
        player.playGame();
    }
}
