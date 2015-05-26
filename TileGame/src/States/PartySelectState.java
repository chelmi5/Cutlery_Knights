package States;

import Engine.Game;

import java.awt.*;

public class PartySelectState implements State{

    private Game mGame;
    private State mExplorationState;

    public PartySelectState(Game game, State explorationState) {
        mGame = game;
        mExplorationState = explorationState;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
