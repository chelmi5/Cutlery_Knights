package States;
import Entities.Mobs.AbstractMob;
import Engine.Game;
import Entities.Characters.AbstractHero;
import Entities.GamePieces.EnemyPiece;
import Graphics.GraphicAssets;
import java.awt.*;
import java.util.ArrayList;

public class BattleState implements State {

    private Game mGame;
    private StateManager mStateManager;
    private AbstractHero[] mParty;
    private ArrayList<EnemyPiece> mEnemyList;
    private int mCombinedPartyHP;
    private int mCombinedEnemyHP;
    private int mEnemyHP;
    private Rectangle mMenuRectangle;
    private int count = 0;
    private int[] mAttackSelected = new int[3];
    private int mTimer = 0;
    private int mTurn = 0;

    private boolean isOver = false;

    public BattleState(Game game, StateManager stateManager) {
        mGame = game;
        mStateManager = stateManager;
    }

    private int enemyHealth() {
        return mEnemyList.get(mGame.getAttackingEnemyID()).getMonster().getStats().getHitPoints();
    }

    private int combinedPartyHealth() {
        int health = 0;
        for (int x = 0; x < mParty.length; x++)
        {
            health += mParty[x].getStats().getHitPoints();
        }
        return health;
    }

    private int combinedEnemyHelth() {
        int health = 0;
        for (int x = 0; x < mEnemyList.size(); x++){
            health += mEnemyList.get(x).getMonster().getStats().getHitPoints();
        }
        return health;
    }

    @Override
    public void update() {
        mTimer++;

        mParty = mGame.getPartyArray();
        mEnemyList = mGame.getMonsterArray();

        mCombinedPartyHP = combinedPartyHealth();
        mCombinedEnemyHP = combinedEnemyHelth();
        mEnemyHP = enemyHealth();

        if (mEnemyHP < 1 || mCombinedPartyHP < 1)
            isOver = true;

        if (isOver)
        {
            if (mEnemyHP < 1 && mGame.getKeyManager().enter)
            {
                System.out.println("Switching back to ExplorationState");
                mTimer = 0;
                mTurn = 0;
                isOver = false;
                count = 0;
                mAttackSelected = new int[3];
                mEnemyList.remove(mEnemyList.get(mGame.getAttackingEnemyID()));
                mGame.setMonsterArray(mEnemyList);
                mGame.killedEnemy();
                StateManager.setState(mStateManager.getExplorationState());
            }
            else if (mCombinedEnemyHP < 1 && mGame.getKeyManager().enter)
            {
                StateManager.setState(mStateManager.getEndState());
            }
            else if (mCombinedPartyHP < 1 && mGame.getKeyManager().enter)
            {
                StateManager.setState(mStateManager.getEndState());
            }
        }
        else
        {
            if (mGame.getKeyManager().backspace && count > 0)
            {
                System.out.println("Backspace: count:" + count);
                if (count == 3)
                    count --;
                mAttackSelected[count] = 0;
                count--;
            }
            if (mGame.getKeyManager().one && count < 3)
            {
                System.out.println("one");
                mAttackSelected[count] = 1;
                count++;
            }

            if (mGame.getKeyManager().two && count < 3)
            {
                System.out.println("two");
                mAttackSelected[count] = 2;
                count++;
            }

            if (mGame.getKeyManager().enter && count == 3 && mTurn == 0) {
                mTurn = 1;
                playerAttack();
                mTimer = 0;
            }

            if (mTurn == 1)
            {
                boolean trigger = false;
                if (mTurn == 1)
                    trigger = enemyAttack();

                if (trigger) {
                    mAttackSelected = new int[3];
                    count = 0;
                    mTimer = 0;
                    mTurn = 0;
                }
            }
        }
    }

    private boolean enemyAttack() {
        if (mTimer > 80) {
            for (int i = 0; i < mParty.length; i++) {
                mParty[i].getStats().setHitPoints(mParty[i].getStats().getHitPoints() -
                        mEnemyList.get(mGame.getAttackingEnemyID()).getMonster().attack(mParty[i]));
            }
            return true;
        }
        return false;
    }

// Player Attacking

    private void playerAttack() {
        int damage = 0;
        AbstractMob monster = mEnemyList.get(mGame.getAttackingEnemyID()).getMonster();
        for (int x = 0; x < mParty.length; x++) {
            if (mParty[x].getStats().getHitPoints() > 0) {
                if (mAttackSelected[x] == 1)
                    damage = mParty[x].attack(monster);
                if (mAttackSelected[x] == 2)
                    damage = mParty[x].specialAbility(monster);
                mGame.setGameScore(damage);
                damage = monster.getStats().getHitPoints() - damage;
                mEnemyList.get(mGame.getAttackingEnemyID()).getMonster().getStats().setHitPoints(damage);
            }
        }
        // mTurn = 1;
    }

    @Override
    public void render(Graphics paintBrush) {

        mParty = mGame.getPartyArray();
        mEnemyList = mGame.getMonsterArray();

        paintBrush.drawImage(GraphicAssets.mBackground, 0, 0, 1200, 725, null);
        paintBrush.drawImage(GraphicAssets.choppingBlock, 800, 75, 400, 200, null);
        paintBrush.drawImage(GraphicAssets.choppingBlock, -10, 250, 400, 200, null);
        Graphics2D twoDpaintBrush = (Graphics2D) paintBrush;
        mMenuRectangle = new Rectangle(0, 450, 1200, 500);
        twoDpaintBrush.drawImage(GraphicAssets.mWood, mMenuRectangle.x, mMenuRectangle.y, 1200, 500, null);

        Font font2 = new Font("arial", Font.BOLD, 30);
        Font font3 = new Font("arial", Font.BOLD, 20);
        Font font4 = new Font("arial", Font.PLAIN, 15);

        paintBrush.setFont(font2);


        double ratio = 1.0;

        for (int x = 1; x < 3+1; x++)
        {
            if (mParty[x-1].getStats().getHitPoints() > 0) {
                ratio = (mParty[x - 1].getStats().getHitPoints() * 1.0) / (mParty[x - 1].getStats().getMaxHitPoints() * 1.0);

                paintBrush.setFont(font3);
                paintBrush.setColor(Color.BLACK);
                paintBrush.drawString(mParty[x - 1].getStats().getName(), 100 + (400 * (x - 1)), 500);
                for (int j = 0; j < mParty[x - 1].getAttackNames().size(); j++)
                    paintBrush.drawString(j + 1 + ". " + mParty[x - 1].getAttackNames().get(j), 80 + (400 * (x - 1)), 550 + (50 * j));

                paintBrush.drawString("Choice: ", 80 + (400 * (x - 1)), 650);

                //System.out.println("Effect num: " + mAttackSelected[x-1]);
                if (mAttackSelected[x - 1] != 0)
                    paintBrush.drawString("" + mAttackSelected[x - 1], 160 + (400 * (x - 1)), 652);

                paintBrush.drawImage(GraphicAssets.mhealthHolder, -10 + (100 * x), 100 - (20 * x), 100, 20, null);
                paintBrush.drawImage(GraphicAssets.mHealth, -10 + (100 * x), 100 - (20 * x), (int) (100 * ratio), 20, null);
                paintBrush.setFont(font4);
                paintBrush.setColor(Color.DARK_GRAY);
                paintBrush.drawString(mParty[x - 1].getStats().getHitPoints() + " / " +
                                mParty[x - 1].getStats().getMaxHitPoints(), 10 + (100 * x), 135 - (20 * x));
                paintBrush.drawImage(mParty[x - 1].getIcon(), -10 + (100 * x), 120 - (20 * x), null);
            }
        }

        int eID = mGame.getAttackingEnemyID();
        ratio = (mEnemyList.get(eID).getMonster().getStats().getHitPoints() * 1.0) /
                (mEnemyList.get(eID).getMonster().getStats().getMaxHitPoints() * 1.0);
        int print = (int)(100 * ratio);
        paintBrush.drawImage(GraphicAssets.mhealthHolder, 1000, 40, 100, 20, null);
        paintBrush.drawImage(GraphicAssets.mHealth, 1000, 40, print, 20, null);
        paintBrush.setFont(font4);
        paintBrush.drawString(mEnemyList.get(eID).getMonster().getStats().getHitPoints() + " / " +
                        mEnemyList.get(eID).getMonster().getStats().getMaxHitPoints(), 1020, 75);
        paintBrush.drawImage(mEnemyList.get(eID).getMonster().getIcon(), 980, 40, 200, 200, null);

        Font font1 = new Font("arial", Font.BOLD, 45);
        paintBrush.setFont(font1);
        String turnString = "";

        if (mTurn == 0 && mEnemyHP > 0 && mCombinedPartyHP > 0)
        {
            turnString = "Your Turn";
        }
        else if(mTurn == 1 && mEnemyHP > 0 && mCombinedPartyHP > 0)
        {
            turnString = "Enemies Turn";
        }
        else if (mEnemyHP < 1 || mCombinedPartyHP < 1)
        {
            turnString = "Fight Over";
        }
        else
        {
            turnString = "";
        }
            paintBrush.setColor(Color.LIGHT_GRAY);
            paintBrush.drawString(turnString, mGame.getWidth() / 3 + 100, 73);
            paintBrush.setColor(Color.BLACK);
            paintBrush.drawString(turnString, mGame.getWidth() / 3 + 101, 75);

        if (((count == 3 || mEnemyHP < 1 || mCombinedPartyHP < 1) && mTurn == 0) || (mCombinedEnemyHP < 1 || mCombinedPartyHP < 1))
        {
            paintBrush.drawImage(GraphicAssets.mEnter, 570, 675, 100, 30, null);
        }

    }

}
