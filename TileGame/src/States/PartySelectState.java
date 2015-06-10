package States;
import Engine.Game;
import Entities.Characters.*;
import Graphics.GraphicAssets;
import java.awt.*;

public class PartySelectState implements State{

    private Game mGame;
    private int count = 0;
    private StateManager mStateManager;
    private String[] partyArray = new String[3];
    private AbstractHero[] mPartyArray = new AbstractHero[3];
    private boolean pressedS = false;
    private CharacterManager mCharacterManager;

    public PartySelectState(Game game, StateManager stateManager) {
        mGame = game;
        mStateManager = stateManager;
        CharacterManager mCharacterManager = new CharacterManager();
    }

    @Override
    public void update() {
        if(mGame.getKeyManager().one && count < 3)
        {
            System.out.println("one");
            partyArray[count] = "Roost Chef";
            mPartyArray[count] = new RoastChef("Roost Chef");
            count++;
        }
        if(mGame.getKeyManager().two && count < 3)
        {
            System.out.println("two");
            partyArray[count] = "Pastry Chef";
            mPartyArray[count] = new PastryChef("Pastry Chef");
            count++;
        }
        if(mGame.getKeyManager().three && count < 3)
        {
            System.out.println("three");
            partyArray[count] = "Saute Chef";
            mPartyArray[count] = new SauteChef("Saute Chef");
            count++;
        }
        if(mGame.getKeyManager().four && count < 3)
        {
            System.out.println("four");
            partyArray[count] = "Vegetable Chef";
            mPartyArray[count] = new VeggieChef("Veggie Chef");
            count++;
        }
        if(mGame.getKeyManager().five && count < 3)
        {
            System.out.println("five");
            partyArray[count] = "Fish Chef";
            mPartyArray[count] = new FishChef("Fish Chef");
            count++;
        }
        if (mGame.getKeyManager().backspace && count > 0) {
            if (count == 3)
            {
                count--;
            }
            System.out.println("Count:" + count);
            partyArray[count] = "";
            mPartyArray[count] = null;
            count--;
        }
        if (mGame.getKeyManager().enter && count == 3)
        {
            StateManager.setState(mStateManager.getExplorationState());
            mGame.setPartyArray(mPartyArray);
        }
        if(mGame.getKeyManager().escape)
        {
            System.out.println("Goodbye Escape");
            System.exit(0);
        }

        if (mGame.getKeyManager().sss)
        {
            if(pressedS)
                pressedS = false;
            else
                pressedS = true;
        }
    }

    @Override
    public void render(Graphics paintBrush) {

        paintBrush.drawImage(GraphicAssets.mBackground, 0, 0, 1200, 725, null);
        Font font1 = new Font("arial", Font.BOLD, 45);
        Font font2 = new Font("arial", Font.BOLD, 30);
        Font font3 = new Font("arial", Font.BOLD, 15);
        Font font4 = new Font("arial", Font.PLAIN, 15);

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
        paintBrush.drawImage(GraphicAssets.mVegetable, 760, 125, 120, 280, null);
        paintBrush.drawImage(GraphicAssets.mFishChef, 960, 125, 120, 280, null);

        paintBrush.setFont(font2);

        paintBrush.drawString("1. Roost", 120, 420);
        paintBrush.drawString("2. Pastry", 350, 420);
        paintBrush.drawString("3. Saute", 560, 420);
        paintBrush.drawString("4. Vegetable", 760, 420);
        paintBrush.drawString("5. FishMob", 960, 420);

        if (pressedS) {
            for (int x = 0; x < mCharacterManager.mCharacterArray.length; x++) {
                paintBrush.setFont(font3);
                paintBrush.drawImage(GraphicAssets.mStatsholder, 100 + (230 * x), 160, 160, 160, null);
                paintBrush.drawString(mCharacterManager.mCharacterArray[x].getStats().getName(), 110 + (230 * x), 185);

                paintBrush.setFont(font4);
                paintBrush.drawString("Health: " + mCharacterManager.mCharacterArray[x].getStats().getChanceToHit(), 110 + (230 * x), 210);
                paintBrush.drawString("Effect Speed: " + mCharacterManager.mCharacterArray[x].getStats().getAttackSpeed(), 110 + (230 * x), 225);
                paintBrush.drawString("Chance to block: " + mCharacterManager.mCharacterArray[x].getChanceToBlock(), 110 + (230 * x), 240);
                paintBrush.drawString("Chance to hit: " + mCharacterManager.mCharacterArray[x].getStats().getChanceToHit(), 110 + (230 * x), 255);
                paintBrush.drawString("Special Effect:", 110 + (230 * x), 280);
                paintBrush.drawString(mCharacterManager.mCharacterArray[x].getAttackNames().get(1), 110 + (230 * x), 295);

            }
        }
        paintBrush.setFont(font2);
        paintBrush.setColor(Color.BLACK);
        paintBrush.drawString("You have chosen the following for your party", mGame.getWidth() / 3 - 100, 500);
        paintBrush.setColor(Color.DARK_GRAY);
        for (int x = 1; x < count+1; x++)
        {
            paintBrush.drawString(mPartyArray[x-1].getStats().getName(), (mGame.getWidth()  / 500 + (300 * x))- 50, 550);
        }

        if (count == 3)
        {
            paintBrush.drawImage(GraphicAssets.mEnter, 570, 600, 100, 30, null);
        }

        paintBrush.setColor(Color.BLACK);
        paintBrush.drawImage(GraphicAssets.mSbutton, 60, 650, 30, 30, null);
        paintBrush.drawString("Toggle character stats", 90, 675);

    }
}
