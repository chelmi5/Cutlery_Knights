package Items;
import Entities.Characters.AbstractHero;

public interface Item {
    String name = null;
    String description = null;

    void action(AbstractHero character);
}
