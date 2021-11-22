package character;

public abstract class Character {
    private final String name;

    public Character(String name){
        this.name = name;
    }

    /**
     * @return Affiche le nom
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return Affichage
     */
    @Override
    public String toString(){
        return "[ " + this.name + " ]";
    }
}
