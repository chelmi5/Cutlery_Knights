package States;

import java.util.ArrayList;

public class StateManager {

    private ArrayList<State> mStatesList;
    private static State currentState = null;

    public StateManager() {
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
}
