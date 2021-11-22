package character;

public abstract class Character {
    private final String name;

    /**
     * @param name Nom du personnage
     */
    Character(String name){
        this.name = name;
    }

    /**
     * @return Affiche le nom d'un personnage
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
