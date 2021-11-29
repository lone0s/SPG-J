package squid.place.game.GuessMyWord;

import squid.Start;
import squid.character.NPC;
import squid.character.Player;
import squid.place.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GuessMyWord extends Game {
    private static final int NB_TRIES = 3;

    public void removePlayer() {

    }

    public GuessMyWord() {
        super("GuessMyWord","Can you guess what word i'm thinking about? \nYou'll get to try your luck three times. \nYou need to get one good word to pass this game. \nGood luck.",new NPC("Ultimate Word Guesser"), genExit2Ways(new HashMap<>(),"GuessMyWord","MainRoom"));
    }

    public void play(Player player) {
        Scanner usrInput = Start.scanner;
        Random rdm = new Random();
        ArrayList<String> keyWords = new ArrayList<>(Wordlist.genKeyWords());
        ArrayList<Integer> uniqueRdms = new ArrayList<>(Wordlist.uniqueRdms());
        String wtWrd = "What word is it that i'm thinking of ?";
        String npcWrd;
        String usrAnswer;
        int round = 0;
        int nbWins = 0;

        System.out.println("\n--- Game launched ---\n");
        while (round < NB_TRIES)
        {
            String rdmKwrd = keyWords.get(uniqueRdms.get(round));
            Wordlist rdmWL = Wordlist.genSpecificWordList(rdmKwrd);
            System.out.println("\n--- Round " + (round+1) +" ---\n");
            this.getNpc().dialog("[*] Alright, i've picked my word, the subject is : [" + rdmKwrd + "]");
            rdmWL.printWords();
            this.getNpc().dialog("[*] Pick a word from the ones above, careful, it's case sensitive :( ");
            npcWrd = rdmWL.pickSpecificWord(rdm.nextInt(Wordlist.NB_WORDLISTS));
            usrAnswer = usrInput.nextLine();

            if (compare2words(npcWrd,usrAnswer)) {
                this.getNpc().dialog("[*] Congratulations, you've picked the right one !");
                nbWins++;
            }
            else{
                this.getNpc().dialog("[*] Oh no, you've lost. I was thinking about "+npcWrd);
            }
            round++;
        }
        if (nbWins > 0) {
            winner();
        }
        else {
            lose(player);
        }
    }


    public boolean compare2words(String fstWrd,String scdWrd) {
        return (fstWrd.equals(scdWrd));
    }
}
