package Characters;

import Objects.PieTin;
import Objects.SpoonAttack;

/**
 * Created by CountryGeek1 on 4/19/2015.
 */
public class FishChef extends GameCharacter {

    public FishChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
    }

    @Override
    public void displayStats() {
        System.out.println("I am a Fish Chef");
    }
}
