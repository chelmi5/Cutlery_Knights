package States;
import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class TitleState implements State {

    private Rectangle mQuitButton;
    private Rectangle mHelpButton;
    private Rectangle mPlayButton;
    private StateManager mStateManager;
    private Game mGame;

    public TitleState(Game game, StateManager stateManager) {
        mGame = game;
        mStateManager = stateManager;
        mPlayButton = new Rectangle((mGame.getWidth() / 3) + 150, 450, 130, 50 );
        mHelpButton = new Rectangle((mGame.getWidth() / 3) + 150, 525, 130, 50 );
        mQuitButton = new Rectangle((mGame.getWidth() / 3) + 150, 600, 130, 50 );
    }

    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mMainScreen, 0, 0, 1200, 725, null);
        Graphics2D twoDpaintBrush = (Graphics2D) paintBrush;
        Font font2 = new Font("arial", Font.BOLD, 30);
        paintBrush.setFont(font2);
        twoDpaintBrush.drawImage(GraphicAssets.mWood, mPlayButton.x, mPlayButton.y, 135, 50, null);
        paintBrush.drawString("1. Play", mPlayButton.x + 20, mPlayButton.y + 35);
        twoDpaintBrush.drawImage(GraphicAssets.mWood, mHelpButton.x, mHelpButton.y, 135, 50, null);
        paintBrush.drawString("2. Help", mHelpButton.x + 20, mHelpButton.y + 35);
        twoDpaintBrush.drawImage(GraphicAssets.mWood, mQuitButton.x, mQuitButton.y, 135, 50, null);
        paintBrush.drawString("3. Quit", mQuitButton.x+20, mQuitButton.y + 35);
    }

    public void update() {
        getInput();
    }

    public void getInput() {

        if(mGame.getKeyManager().one)
        {
            StateManager.setTitleState(this);
            StateManager.setState(mStateManager.getPartySeclectionState());
            System.out.println("PlayerPiece");
        }
        if(mGame.getKeyManager().two)
        {
            StateManager.setState(mStateManager.getHelpState());
            System.out.println("Help");
        }
        if(mGame.getKeyManager().three) {
            System.out.println("GoodBye");
            System.exit(1);
        }
    }
}
