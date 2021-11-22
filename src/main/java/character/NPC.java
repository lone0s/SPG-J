package character;

public class NPC extends Character {

    // Constructor
    public NPC(String name) {
        super(name);
    }

    // Methode pour afficher les dialogues du NPC
    public void dialog(String dialog) {
        System.out.println(this + dialog);
    }

}
