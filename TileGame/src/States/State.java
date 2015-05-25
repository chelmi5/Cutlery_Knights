package States;
import Engine.Game;
import java.awt.*;

public abstract class State {

    protected Game mGame;

    public State(Game game) {
        mGame = game;
    }

    public abstract void update();
    public abstract void render(Graphics g);

}
