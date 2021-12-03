package squid.place.game.GuessMyWord;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Wordlist {
    public static final int NB_WORDLISTS = 5;
    public static final int NB_CHANCES = 3;


    private final List<String> Words;


    public Wordlist(List<String> myWords) {
        this.Words = myWords;
    }

    public List<String> getWords() {
        return Words;
    }
    /*
    * Affichage des mots d'un dictionnaire
     */
    public void printWords() {
        for (int i = 0 ; i < this.Words.size() ; i++) {
            System.out.println("Word [" + (i+1) + "] : " + this.Words.get(i));
        }
    }
    /*
    *   Permet de récuperer un mot précis d'une liste de mots
     */

    public String pickSpecificWord(int i){
        return this.Words.get(i);
    }


    public String pickRdmWord() {
        Random rdm = new Random();
        int rdmVal = rdm.nextInt(this.Words.size());
        return this.Words.get(rdmVal);
    }
    /*
    *   Genere l'ensemble des mots clés des listes
     */
    public static ArrayList<String> genKeyWords() {
        ArrayList<String> myKeywords = new ArrayList<>();
        myKeywords.add("Animals");
        myKeywords.add("Games");
        myKeywords.add("Objects");
        myKeywords.add("Presidents");
        myKeywords.add("Artists");
        return myKeywords;
    }
    /*
     * uniqueRdms() : Permet de générer une liste de nombres aléatoires
     *                tout en évitant d'obtenir deux fois le même nombre.
     *                Cela nous évitera de générer deux fois la même liste.
     */
    public static ArrayList<Integer> uniqueRdms() {
        Random rdm = new Random() ;
        Set<Integer> rdmValues = new LinkedHashSet<Integer>(); //Permet d'éliminer la redondance des valeurs aléatoires
        while (rdmValues.size() < NB_CHANCES){
            rdmValues.add(rdm.nextInt(NB_WORDLISTS));
        }
        return new ArrayList<>(rdmValues);
    }

    public static Wordlist genAnimalList() {
        List<String>myAnimals = new ArrayList<>();
        myAnimals.add("Dog");
        myAnimals.add("Cat");
        myAnimals.add("Hamster");
        myAnimals.add("Bear");
        myAnimals.add("Platypus");
        return new Wordlist(myAnimals);
    }

    public static Wordlist genObjectList() {
        List<String>myObjects = new ArrayList<>();
        myObjects.add("Table");
        myObjects.add("Monitor");
        myObjects.add("Mouse");
        myObjects.add("Keyboard");
        myObjects.add("Chair");
        return new Wordlist(myObjects);
    }

    public static Wordlist genPresidentList() {
        List<String>myPresidents = new ArrayList<>();
        myPresidents.add("Macron");
        myPresidents.add("Hollande");
        myPresidents.add("Sarkozy");
        myPresidents.add("Chirac");
        myPresidents.add("Mitterand");
        return new Wordlist(myPresidents);
    }

    public static Wordlist genArtistList() {
        List<String>myArtists = new ArrayList<>();
        myArtists.add("Picasso");
        myArtists.add("Ernst");
        myArtists.add("Dali");
        myArtists.add("Duchamp");
        myArtists.add("Magritte");
        return new Wordlist(myArtists);
    }

    public static Wordlist genGameList() {
        List<String>myGames = new ArrayList<>();
        myGames.add("GTA");
        myGames.add("Counter-strike");
        myGames.add("Fallout");
        myGames.add("Doom");
        myGames.add("Pacman");
        return new Wordlist(myGames);
    }
    /*
    * Permet de generer une liste de mots spécifique a partir d'un String correspondant a un mot clef
     */
    public static Wordlist genSpecificWordList(String myWord){
        Wordlist myWords = new Wordlist(new ArrayList<>());
        switch (myWord) {
            case "Animals" :
                myWords = genAnimalList();
                break;
            case "Games" :
                myWords = genGameList();
                break;
            case "Objects" :
                myWords = genObjectList();
                break;
            case "Presidents" :
                myWords = genPresidentList();
                break;
            case "Artists" :
                myWords = genArtistList();
                break;
        }
        return myWords;
    }

}
