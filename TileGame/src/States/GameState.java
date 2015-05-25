package States;
import java.awt.*;
import Engine.Game;
import Entities.Creatures.Player;
import Map.Map;

public class GameState extends State {

    private Player mPlayer;
    private Map world;

    public GameState(Game game) {
        super(game);
        // takes in starting position
        mPlayer = new Player(game, 100, 100);
        world = new Map(game, "map1.txt");
    }

    @Override
    public void update() {
        world.update();
        mPlayer.update();
    }

    @Override
    public void render(Graphics paintBrush) {
        world.render(paintBrush);
        mPlayer.render(paintBrush);
    }

    public Map getWorld() {
        return world;
    }
}
