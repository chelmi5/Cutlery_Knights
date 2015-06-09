package Items;
import Entities.Characters.AbstractHero;

import java.awt.*;

public interface Item {
    String name = null;
    String description = null;

    void action(AbstractHero character);

    Image getIcon();
}
