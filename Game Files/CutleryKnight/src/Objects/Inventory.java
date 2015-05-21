package Objects;
import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> mInventory = new ArrayList<Item>();

    public void displayInvitory()
    {
        System.out.println("Inventory contains:");
        for (int i = 0; i < mInventory.size(); i++){
            System.out.println(i + ": " + mInventory.get(i));
        }
    }

    public void addItem(Item item) {
        mInventory.add(item);
    }

    public void removeItem(Item item) {
        mInventory.remove(item);
    }
}
