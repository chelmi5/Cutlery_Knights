package Entities.Characters;

public class CharacterManager {

    public static AbstractHero[] mCharacterArray = new AbstractHero[5];

    public CharacterManager() {
        mCharacterArray[0] = new RoastChef("Roost Chef");
        mCharacterArray[1] = new PastryChef("Pastry Chef");
        mCharacterArray[2] = new SauteChef("Saute Chef");
        mCharacterArray[3] = new VeggieChef("Veggie Chef");
        mCharacterArray[4] = new FishChef("FishMob Chef");
    }
}
