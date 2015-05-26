package States;
import Engine.Game;

public class StateManager {

    private State mExplorationState;
    private State mTitleState;
    private State mEndState;
    private State mPartySeclectionState;
    private State mBattleState;
    private State mMenuState;
    private static State currentState = null;

    public StateManager(Game game) {
        mMenuState = new MenuState(game, this);
        mExplorationState = new ExplorationState(game, mMenuState, mEndState);
        mPartySeclectionState = new PartySelectState(game,mExplorationState);
        mTitleState = new TitleState(game, mExplorationState);                  // This will need to be changed to mPartySelection
        mEndState = new EndState(game, mTitleState);
        mBattleState = new BattleState(game, mExplorationState, mMenuState, mEndState);
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

    public State getExplorationState() {
        return mExplorationState;
    }

    public State getTitleState() {
        return mTitleState;
    }

    public State getEndState() {
        return mEndState;
    }

    public State getBattleState() {
        return mBattleState;
    }
}
