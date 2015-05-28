package States;
import java.awt.*;
import Engine.Game;
import Entities.Creatures.Player;
import Map.Map;

public class ExplorationState implements State {

    private Player mPlayer;
    private Map mMap;
    private Game mGame;
    private State mMenuState;
    private State mEndState;
    private State mBattleState;

    public ExplorationState(Game game, State menuState, State endState, StateManager stateManager) {
        mGame = game;
        mMap = new Map(game, "map1.txt");
        mPlayer = new Player(game, 100, 100, mMap);
        mMenuState = menuState;
        mEndState = endState;
        mBattleState = stateManager.getBattleState();
    }

    @Override
    public void update() {
        mMap.update();
        mPlayer.update();

        if(mGame.getKeyManager().escape)
        {
            System.out.println("GoodBye");
            System.exit(0);
        }
        if (mGame.getKeyManager().jay)
        {
            StateManager.setState(mBattleState);
        }
    }

    @Override
    public void render(Graphics paintBrush) {
        mMap.render(paintBrush);
        mPlayer.render(paintBrush);
    }

    public Player getPlayer() {
        return mPlayer;
    }
}
