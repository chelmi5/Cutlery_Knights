package Objects;
import Characters.GameCharacter;

public abstract class Item {
    protected String name;
    protected String description;
    
    public abstract void action(GameCharacter hero);
    //should perform an action like add xp
}
