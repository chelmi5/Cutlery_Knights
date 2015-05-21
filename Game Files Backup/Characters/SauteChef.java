package Characters;

import Objects.PieTin;
import Objects.SpoonAttack;

/**
 * Created by CountryGeek1 on 4/19/2015.
 */
public class SauteChef extends GameCharacter {

    public SauteChef() {
        mAttack = new SpoonAttack();
        mDefend = new PieTin();
    }

    @Override
    public void displayStats() {
        System.out.println("I am a Saute Chef");
    }
}
