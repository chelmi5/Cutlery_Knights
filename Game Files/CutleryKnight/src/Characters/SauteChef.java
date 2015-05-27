package Characters;
import Objects.PieTin;
import Objects.SpoonAttack;
import Objects.Stats;

public class SauteChef extends GameCharacter {

    public SauteChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
        mStats = new Stats(95, 5, 4);
    }

    @Override
    public void displayStats() {
        System.out.println("I am a Saute Chef");
        mStats.displayStats();
    }
}
