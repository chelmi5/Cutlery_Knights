package Entities.Characters;

import Entities.AbstractHero;

/**
 * Created by CountryGeek1 on 6/7/15.
 */
public class CharacterManager {

    public static AbstractHero[] mCharacterArray = new AbstractHero[5];

    public CharacterManager() {
        mCharacterArray[0] = new FishChef("Roost Chef");
        mCharacterArray[1] = new PastryChef("Pastry Chef");
        mCharacterArray[2] = new SauteChef("Saute Chef");
        mCharacterArray[3] = new PastryChef("Veggie Chef");
        mCharacterArray[4] = new FishChef("Fish Chef");
    }
}
