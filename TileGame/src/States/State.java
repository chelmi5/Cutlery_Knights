package States;
import Entities.Player;

import java.awt.*;

public interface State {

    void update();
    void render(Graphics g);
}
