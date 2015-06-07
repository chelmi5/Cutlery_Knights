package States;
import Engine.Game;

public class StateManager {

    private State mExplorationState;
    private static State mTitleState;
    private State mEndState;
    private State mPartySeclectionState;
    private State mBattleState;
    private State mHelpState;
    private State mMenuState;
    private StateManager mStateManager;
    private static State currentState = null;

    public StateManager(Game game) {
        mBattleState = new BattleState(game, this);
        mExplorationState = new ExplorationState(game, this);
        mMenuState = new MenuState(game, this);
        mPartySeclectionState = new PartySelectState(game, this);
        mTitleState = new TitleState(game, this);                  // This will need to be changed to mPartySelection
        mEndState = new EndState(game, this);
        mHelpState = new HelpState(game, this);
        mStateManager = this;
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

    public State getPartySeclectionState() {
        return mPartySeclectionState;
    }

    public State getExplorationState() {
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

    public State getMenuState() {
        return mMenuState;
    }

    public State getHelpState() {
        return mHelpState;
    }

    public void setHelpState(State helpState) {
        mHelpState = helpState;
    }

    public void createNewExplorationState(Game game) {
        mExplorationState = new ExplorationState(game, this);
    }
}
