package Characters;
import Objects.PieTin;
import Objects.SpoonAttack;
import Objects.Stats;

public class RoastChef extends GameCharacter {

    public RoastChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
    }

    @Override
    public void displayStats() {
        System.out.println("I am the Roast Chef");
    }
}
