package States;
import java.awt.*;
import Engine.Game;
import Entities.Mobs.*;
import Entities.Player;
import Map.Map;
import Utilities.CodeTools;

public class ExplorationState implements State {

    private Player mPlayer;
    private Map mMap;
    private Game mGame;
    private StateManager mStateManager;
    private Bread bread;
    private Bread bread2;

    public ExplorationState(Game game, StateManager stateManager) {
        mGame = game;
        mMap = mGame.getMap();
        mStateManager = stateManager;
        mPlayer = new Player(game, 100, 100, mMap);
        bread = new Bread(game, 100 + CodeTools.randInt(20, 400), 100 + CodeTools.randInt(20, 400), mMap);
        bread2 = new Bread(game, 100 + + CodeTools.randInt(200, 600), 100  + CodeTools.randInt(200, 600), mMap);
    }

    @Override
    public void update() {
        mMap.update();
        mPlayer.update();
        bread.update();
        bread2.update();

        if(mGame.getKeyManager().escape)
        {
            System.out.println("GoodBye");
            //System.exit(0);
        }
        if (mGame.getKeyManager().jay)
        {
            StateManager.setState(mStateManager.getBattleState());
        }
    }

    @Override
    public void render(Graphics paintBrush) {
        mMap.render(paintBrush);
        mPlayer.render(paintBrush);
        bread.render(paintBrush);
        bread2.render(paintBrush);
    }

    public Player getPlayer() {
        return mPlayer;
    }
}
