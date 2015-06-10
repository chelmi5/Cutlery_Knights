package Items;

public class SimpleItemFactory {

    public SimpleItemFactory(){
    }

    public Item createItem(int num) {

        num--;
        String type = "";
        String itemsArray[] = {"Oregano", "Rosemary", "Pepper"};
        type = itemsArray[num];

        if (type.equalsIgnoreCase("Oregano"))
            return new Oregano();
        else if (type.equalsIgnoreCase("Rosemary"))
            return new Rosemary();
        else if (type.equalsIgnoreCase("Pepper"))
            return new Pepper();
        else
            return null;
    }
}
