package Characters;

import Objects.AttackBehavior;
import Objects.PieTin;
import Objects.SpoonAttack;

/**
 * Created by CountryGeek1 on 4/19/2015.
 */
public class PastryChef extends GameCharacter {

    public PastryChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
    }

    @Override
    public void displayStats() {
        System.out.println("I am a Pastry Chef");
    }
}
