package Characters;

import Objects.Inventory;

/**
 * Created by CountryGeek1 on 5/15/2015.
 */
public class CharacterParty {
    GameCharacter GamePartyArray[] = new GameCharacter[3];
    Inventory mInventory = new Inventory();

    public GameCharacter[] getParty()
    {
        return GamePartyArray;
    }

    public void displayParty() {
        for(int i = 0; i < GamePartyArray.length; i++) {
            GamePartyArray[i].displayStats();
        }
        mInventory.displayInvitory();
    }
}
