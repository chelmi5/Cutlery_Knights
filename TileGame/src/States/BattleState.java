package States;

import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class BattleState implements State {

    private Game mGame;
    private State mExplorationState;
    private State mMenuState;
    private State mEndState;

    public BattleState(Game game) {
        mGame = game;
        //mExplorationState = expolorationState;
        //mMenuState = menuState;
        //mEndState = endState;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mBackground, 0, 0, 1200, 725, null);
        paintBrush.drawImage(GraphicAssets.choppingBlock, 800, 75, 400,200, null);
        paintBrush.drawImage(GraphicAssets.choppingBlock, -10, 250, 400,200, null);
    }
}
