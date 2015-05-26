package States;
import Engine.Game;
import java.awt.*;

public class EndState implements State {

    private Game mGame;
    private State mTileState;

    public EndState(Game game, State TileState) {
        mGame = game;
        mTileState = TileState;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
