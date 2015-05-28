package States;
import Engine.Game;
import java.awt.*;

public class StateManager {

    private ExplorationState mExplorationState;
    private static State mTitleState;
    private State mEndState;
    private State mPartySeclectionState;
    private State mBattleState;
    private State mMenuState;
    private static State currentState = null;

    public StateManager(Game game) {
        mBattleState = new BattleState(game);
        mExplorationState = new ExplorationState(game, mMenuState, mEndState, this);
        mMenuState = new MenuState(game, this);
        mPartySeclectionState = new PartySelectState(game, mExplorationState, this);
        mTitleState = new TitleState(game, mPartySeclectionState);                  // This will need to be changed to mPartySelection
        mEndState = new EndState(game, mTitleState);
        mBattleState = new BattleState(game);
        setState(mTitleState);
    }

    public void update() {
        currentState.update();
    }

    public static void setState(State pState) {
        currentState = pState;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public ExplorationState getExplorationState() {
        return mExplorationState;
    }

    public State getTitleState() {
        return mTitleState;
    }

    public static void setTitleState(State titleState) {
        mTitleState = titleState;
    }

    public State getEndState() {
        return mEndState;
    }

    public State getBattleState() {
        return mBattleState;
    }
}
