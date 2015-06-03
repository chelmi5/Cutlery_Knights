package States;
import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class PartySelectState implements State{

    private Game mGame;
    private int count = 0;
    private StateManager mStateManager;
    private Rectangle mPlayButton;
    private Rectangle mHelpButton;
    private Rectangle mQuitButton;
    private String[] partyArray = new String[3];

    public PartySelectState(Game game, StateManager stateManager) {
        mGame = game;
        mStateManager = stateManager;
        mPlayButton = new Rectangle((mGame.getWidth() / 3) + 120, 150, 100, 50 );
        mHelpButton = new Rectangle((mGame.getWidth() / 3) + 120, 250, 100, 50 );
        mQuitButton = new Rectangle((mGame.getWidth() / 3) + 120, 350, 100, 50 );
    }

    @Override
    public void update() {
        if(mGame.getKeyManager().one && count < 3)
        {
            System.out.println("one");
            partyArray[count] = "Roost Chef";
            count++;
        }
        if(mGame.getKeyManager().two && count < 3)
        {
            System.out.println("two");
            partyArray[count] = "Pastry Chef";
            count++;
        }
        if(mGame.getKeyManager().three && count < 3)
        {
            System.out.println("three");
            partyArray[count] = "Saute Chef";
            count++;
        }
        if(mGame.getKeyManager().four && count < 3)
        {
            System.out.println("four");
            partyArray[count] = "Vegetable Chef";
            count++;
        }
        if(mGame.getKeyManager().five && count < 3)
        {
            System.out.println("five");
            partyArray[count] = "Fish Chef";
            count++;
        }
        if (mGame.getKeyManager().backspace && count > 0) {
            if (count == 3)
            {
                count--;
            }
            System.out.println("Count:" + count);
            partyArray[count] = "";
            count--;
        }
        if (mGame.getKeyManager().enter && count == 3)
        {
            StateManager.setState(mStateManager.getExplorationState());
        }
        if(mGame.getKeyManager().escape)
        {
            System.out.println("Goodbye Escape");
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics paintBrush) {

        paintBrush.drawImage(GraphicAssets.mBackground, 0, 0, 1200, 725, null);
        Font font1 = new Font("arial", Font.BOLD, 45);
        Font font2 = new Font("arial", Font.BOLD, 30);

        paintBrush.setFont(font1);
        paintBrush.setColor(Color.LIGHT_GRAY);
        paintBrush.drawString("Party Selection", mGame.getWidth() / 3 + 29, 73);
        paintBrush.setColor(Color.BLACK);
        paintBrush.drawString("Party Selection", mGame.getWidth() / 3 + 30, 75);
        paintBrush.setFont(font2);
        paintBrush.drawString("(Choose 3 numbers for your Party Choices)", mGame.getWidth() / 3 - 80, 120);

        paintBrush.drawImage(GraphicAssets.mRoost, 120, 125, 120, 280, null);
        paintBrush.drawImage(GraphicAssets.mPastry, 350, 125, 120, 280, null);
        paintBrush.drawImage(GraphicAssets.mSaute, 560, 125, 120, 280, null);
        paintBrush.drawImage(GraphicAssets.mVegtable, 760, 125, 120, 280, null);
        paintBrush.drawImage(GraphicAssets.mFish, 960, 125, 120, 280, null);

        paintBrush.setFont(font2);
        paintBrush.setColor(Color.BLACK);
        paintBrush.drawString("You have chosen the following for your party", mGame.getWidth() / 3 - 100, 500);
        paintBrush.setColor(Color.DARK_GRAY);
        for (int x = 1; x < count+1; x++)
        {
            paintBrush.drawString(partyArray[x-1], mGame.getWidth()  / 500 + (300 * x), 550);
        }

    }
}
