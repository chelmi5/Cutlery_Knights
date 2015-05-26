package States;

import Engine.Game;

import java.awt.*;

public class BattleState implements State {

    private Game mGame;
    private State mExplorationState;
    private State mMenuState;
    private State mEndState;

    public BattleState(Game game, State expolorationState, State menuState, State endState) {
        mGame = game;
        mExplorationState = expolorationState;
        mMenuState = menuState;
        mEndState = endState;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
