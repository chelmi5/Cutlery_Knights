package States;
import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class TitleState implements State {

    private State mPartySelectState;
    private Game mGame;

    public TitleState(Game game, State chooseCharState) {
        mGame = game;
        mPartySelectState = chooseCharState;
    }

    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mMainScreen, 0, 0, 1200, 725, null);
    }

    public void update() {
        getInput();
    }

    public void getInput() {
        if(mGame.getKeyManager().one)
        {
            StateManager.setState(mPartySelectState);
            System.out.println("Yahoo");
        }
    }
}
