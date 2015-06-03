package States;

import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class BattleState implements State {

    private Game mGame;
    private StateManager mStateManager;

    public BattleState(Game game, StateManager stateManager) {
        mGame = game;
        mStateManager = stateManager;
    }

    @Override
    public void update() {
        if(mGame.getKeyManager().escape)
        {
            StateManager.setState(mStateManager.getExplorationState());
        }
        if (mGame.getKeyManager().kay)
        {
            StateManager.setState(mStateManager.getEndState());
        }
    }

    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mBackground, 0, 0, 1200, 725, null);
        paintBrush.drawImage(GraphicAssets.choppingBlock, 800, 75, 400, 200, null);
        paintBrush.drawImage(GraphicAssets.choppingBlock, -10, 250, 400, 200, null);
    }
}
