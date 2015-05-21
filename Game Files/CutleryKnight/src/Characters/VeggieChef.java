package Characters;
import Objects.PieTin;
import Objects.SpoonAttack;
import Objects.Stats;

public class VeggieChef extends GameCharacter {

    private Stats mStats;

    public VeggieChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
        mStats = new Stats(85, 12, 4);
    }

    @Override
    public void displayStats() {
        System.out.println("I am a veggie Chef.");
        mStats.displayStats();
    }
}
