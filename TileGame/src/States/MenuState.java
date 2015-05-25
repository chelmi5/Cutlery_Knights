package States;
import Engine.Game;
import Graphics.Assets;
import java.awt.*;

public class MenuState extends State {

    private State switchStateOne;

    public MenuState(Game game, State switchState) {
        super(game);
        switchStateOne = switchState;
    }

    public void render(Graphics paintBrush) {
        paintBrush.drawImage(Assets.mMainScreen, 0, 0, 1200, 725, null);
    }

    public void update() {
        getInput();
    }

    public void getInput() {
        if(mGame.getKeyManager().one)
        {
            StateManager.setState(switchStateOne);
            System.out.println("Yahoo");
        }
    }
}
