package Characters;
import Objects.Inventory;

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

    public void displayStats() {
        for (int i = 0; i < GamePartyArray.length; i++)
        {

        }
    }
}
