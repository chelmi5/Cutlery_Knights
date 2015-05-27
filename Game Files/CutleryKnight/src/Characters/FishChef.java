package Characters;
import Objects.PieTin;
import Objects.SpoonAttack;
import Objects.Stats;

public class FishChef extends GameCharacter {

    public FishChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
        mStats = new Stats(100, 3, 2);
    }

    @Override
    public void displayStats() {
        System.out.println("I am a Fish Chef");
        mStats.displayStats();
    }
}
