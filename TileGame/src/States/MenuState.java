package States;
import Engine.Game;
import Entities.GamePieces.PlayerPiece;

import java.awt.*;

public class MenuState implements State {

    private Game mGame;
    private PlayerPiece mPlayerPiece;
    private StateManager mStateMager;

    public MenuState(Game game, StateManager stateManager) {
        mGame = game;
        mStateMager = stateManager;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
