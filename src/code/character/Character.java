package code.character;

public abstract class Character {

    private final String name;

    // CONSTRUCTOR
    public Character(String name){
        this.name = name;
    }

    //Getter sur le nom
    public String getName() {
        return this.name;
    }

    // Override de toString
    @Override
    public String toString(){
        return "[" + this.name + "]";
    }
}
