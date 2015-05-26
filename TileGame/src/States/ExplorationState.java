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

    public ExplorationState(Game game, State menuState, State endState) {
        mGame = game;
        // takes in starting position
        mPlayer = new Player(game, 100, 100);
        mMap = new Map(game, "map1.txt");
        mMenuState = menuState;
        mEndState = endState;
    }

    @Override
    public void update() {
        mMap.update();
        mPlayer.update();
    }

    @Override
    public void render(Graphics paintBrush) {
        mMap.render(paintBrush);
        mPlayer.render(paintBrush);
    }

    //public static boolean isMoveable(int x, int y) {
        //return mMap.isMoveable(x, y);
    //}
}
