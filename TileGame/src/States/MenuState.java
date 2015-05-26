package States;
import Engine.Game;
import java.awt.*;

public class MenuState implements State {

    private Game mGame;
    private StateManager mStateMager;
    private State mEndState;
    private State mExplorationState;
    private State mBattleState;
    private State mTileState;

    public MenuState(Game game, StateManager stateManager) {
        mGame = game;
        mStateMager = stateManager;
        mEndState = mStateMager.getEndState();
        mExplorationState = mStateMager.getExplorationState();
        mBattleState = mStateMager.getBattleState();
        mTileState = mStateMager.getTitleState();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
