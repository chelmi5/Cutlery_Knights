package States;
import Engine.Game;
import Graphics.GraphicAssets;
import java.awt.*;

public class HelpState implements State{

    private StateManager mStateManager;
    private Rectangle mPlayButton;
    private Rectangle mTitleButton;
    private Game mGame;

    public HelpState(Game game, StateManager stateManager) {
        mGame = game;
        mStateManager = stateManager;
        mPlayButton = new Rectangle(1000, 600, 130, 50 );
        mTitleButton = new Rectangle(100, 600, 130, 50 );
    }

    @Override
    public void update() {
        getInput();
    }

    public void getInput() {

        if(mGame.getKeyManager().two)
        {
            StateManager.setState(mStateManager.getPartySeclectionState());
            System.out.println("PlayerSelectionState");
        }
        if(mGame.getKeyManager().one)
        {
            StateManager.setState(mStateManager.getTitleState());
            System.out.println("TitleState");
        }

    }

    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mBackground, 0, 0, 1200, 725, null);
        Graphics2D twoDpaintBrush = (Graphics2D) paintBrush;
        Font font1 = new Font("arial", Font.BOLD, 45);
        Font font2 = new Font("arial", Font.BOLD, 30);
        Font font3 = new Font("arial", Font.PLAIN,25);

        paintBrush.setFont(font1);
        paintBrush.setColor(Color.LIGHT_GRAY);
        paintBrush.drawString("How to Play", mGame.getWidth() / 3 + 29, 73);
        paintBrush.setColor(Color.BLACK);
        paintBrush.drawString("How to Play", mGame.getWidth() / 3 + 30, 75);

        paintBrush.setFont(font3);
        paintBrush.drawString("In player selection choose 3 players to help fight your battles. ", 100, 180);
        paintBrush.drawString("(using the number pads to select characters)", 100, 210);
        paintBrush.drawString("Once on the map you can move around (using 'W' 'S' 'A' 'D' or the arrow keys to move.)", 100, 270);
        paintBrush.drawString("If you hit an enemy you will immediately start to fight the delectable food.", 100, 330);
        paintBrush.drawString("When fighting you will take turns with the enemy attacking or defending.", 100, 390);
        paintBrush.drawString("Flip through the menu in order to select your action and hit enter.", 100, 450);
        paintBrush.drawString("You will return to the map if you have chopped the food.", 100, 510);
        paintBrush.drawString("If all the players in your party have been killed you lose.", 100, 570);


        paintBrush.setFont(font2);
        twoDpaintBrush.drawImage(GraphicAssets.mWood, mPlayButton.x, mPlayButton.y, 135, 50, null);
        paintBrush.drawString("2. Play", mPlayButton.x + 20, mPlayButton.y + 35);

        twoDpaintBrush.drawImage(GraphicAssets.mWood, mTitleButton.x, mTitleButton.y, 135, 50, null);
        paintBrush.drawString("1. Back", mTitleButton.x + 20, mTitleButton.y + 35);
    }
}
