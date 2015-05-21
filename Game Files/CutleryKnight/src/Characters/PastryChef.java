package Characters;
import Objects.PieTin;
import Objects.SpoonAttack;
import Objects.Stats;

public class PastryChef extends GameCharacter {

    private Stats mStats;

    public PastryChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
        mStats = new Stats(100, 10, 1);
    }

    public void displayStats() {
        System.out.println("I am a Pastry Chef");
        mStats.displayStats();
    }
}
