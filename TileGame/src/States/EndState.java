package States;
import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class EndState implements State {

    private Game mGame;
    private int mTime = 0;
    private StateManager mStateManager;
    private int mCounter = 1;

    public EndState(Game game, StateManager stateManager) {
        mGame = game;
        mStateManager = stateManager;
    }

    @Override
    public void update() {
        if(mGame.getKeyManager().escape)
        {
            StateManager.setState(mStateManager.getTitleState());
            System.out.println("Title");
        }
    }

    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mBackground, 0, 0, 1200, 725, null);
        Font font1 = new Font("arial", Font.BOLD, 45);
        Font font2 = new Font("arial", Font.BOLD, 30);

        paintBrush.setFont(font1);
        paintBrush.setColor(Color.LIGHT_GRAY);
        paintBrush.drawString("You Win", mGame.getWidth() / 3 + 100, 73);
        paintBrush.setColor(Color.BLACK);
        paintBrush.drawString("You Win", mGame.getWidth() / 3 + 101, 75);

        paintBrush.setFont(font2);
        paintBrush.drawString("Your score was " + mGame.getGameScore(), 100, 200);

        mTime++;
        if (mTime < 30) {
            paintBrush.drawImage(GraphicAssets.mFish, mCounter * (100), 460, 120, 280, null);
            paintBrush.drawImage(GraphicAssets.mEnemy, mCounter * (100) + 200, 620, 64, 64, null);
            paintBrush.drawImage(GraphicAssets.mEnemy, mCounter * (100) + 300, 620, 64, 64, null);
        }
        else {
            mCounter ++;
            mTime = 0;
        }

        if (mCounter == 13)
        {
            mCounter = 0;
        }
    }
}
