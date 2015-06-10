package Entities.Characters;

public class CharacterManager {

    public static AbstractHero[] mCharacterArray = new AbstractHero[5];

    public CharacterManager() {
        mCharacterArray[0] = new FishChef("Roost Chef");
        mCharacterArray[1] = new PastryChef("Pastry Chef");
        mCharacterArray[2] = new SauteChef("Saute Chef");
        mCharacterArray[3] = new PastryChef("Veggie Chef");
        mCharacterArray[4] = new FishChef("FishMob Chef");
    }
}
