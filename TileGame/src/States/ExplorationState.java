package States;
import java.awt.*;
import java.util.ArrayList;
import Items.Item;
import Engine.Game;
import Entities.GamePieces.EnemyPiece;
import Entities.GamePieces.ItemPiece;
import Entities.GamePieces.PlayerPiece;
import Entities.Mobs.*;
import Items.Oregano;
import Items.SimpleItemFactory;
import Map.Map;
import Graphics.GraphicAssets;
import Utilities.CodeTools;

public class ExplorationState implements State {

    private PlayerPiece mPlayerPiece;
    private Map mMap;
    private Game mGame;
    private StateManager mStateManager;
    private ArrayList<EnemyPiece> mMonsterArray = new ArrayList<EnemyPiece>();
    private ArrayList<ItemPiece> itemList = new ArrayList<ItemPiece>();
    private String mEffectString = "";
    private int mTime = 0;
    private boolean runTime = false;
    private int enemyID = 0;

    public ExplorationState(Game game, StateManager stateManager) {
        mGame = game;
        mMap = mGame.getMap();
        mStateManager = stateManager;
        mPlayerPiece = new PlayerPiece(game, 100, 100, mMap);
        generateEnemies(mGame);
        generateItems(mGame);
    }

    private void generateEnemies(Game game) {
        RoundOneFactory mobFactory = new RoundOneFactory();

        for(int x = 0; x < 6; x++) {

            String mobString;
            int randNum = CodeTools.randInt(1, 3);
            if (randNum == 1)
                mobString = "fishmob";
            else if (randNum == 2)
                mobString = "donutmob";
            else if (randNum == 3)
                mobString = "eggsmob";
            else
                mobString = "";

            int temp1 = 100 + CodeTools.randInt(20, 600);
            int temp2 = 100 + CodeTools.randInt(20, 600);
            while( collision(temp1, temp2))
            {
                temp1 = 100 + CodeTools.randInt(20, 600);
                temp2 = 100 + CodeTools.randInt(20, 600);
            }
                System.out.println("Check");

            AbstractMob newMob = mobFactory.makeMob(mobString, enemyID);
            mMonsterArray.add(new EnemyPiece(game, temp1, temp2, mMap, mPlayerPiece, newMob));
            enemyID ++;
        }
        mGame.setmOriginalSize(mMonsterArray.size());
        mGame.setMonsterArray(mMonsterArray);
    }

    private void generateItems(Game game)
    {
        SimpleItemFactory newItemFactory = new SimpleItemFactory();
        for(int x = 0; x < 4; x++) {

            int temp1 = 100 + CodeTools.randInt(20, 600);
            int temp2 = 100 + CodeTools.randInt(20, 600);
            while( collision(temp1, temp2))
            {
                temp1 = 100 + CodeTools.randInt(20, 800);
                temp2 = 100 + CodeTools.randInt(20, 800);
            }
            System.out.println("Check");

            int rand = CodeTools.randInt(1, 3);
            Item newItem = newItemFactory.createItem(rand);
            itemList.add(new ItemPiece(game, temp1, temp2, mMap, mPlayerPiece, newItem, this));
        }
        mGame.setItems(itemList);
    }

    private boolean collision(int numX, int numY) {
            int newX = 0;
            int newY = 0;
            boolean trigger = false;
            for (int courners = 0; courners < 4; courners++){
                newX = (numX + courners % 2 * 52 - 20) / 64;
                newY = (numY + courners / 2 * 58) / 64;
                trigger = mMap.getTile(newX, newY).isSolid();
            }
            return trigger;
    }


    @Override
    public void update() {
        mMap.update();
        mPlayerPiece.update();
        itemList = mGame.getItems();

        if (runTime)
            mTime++;
        if (mTime > 120)
        {
            mEffectString = "";
            runTime = false;
            mTime = 0;
        }

        for (int x = 0; x < itemList.size(); x++)
        {
            itemList.get(x).update();
            if (itemList.get(x).getHit())
                itemList.remove(x);
        }
        mGame.setItems(itemList);

        for (int x = 0; x < mMonsterArray.size(); x++) {
            mMonsterArray.get(x).update();
        }

        if (mGame.getKeyManager().escape) {
            System.out.println("GoodBye");
            //System.exit(0);
        }
        for (int x = 0; x < mMonsterArray.size(); x++) {
            if (mMonsterArray.get(x).isFight()) {
                StateManager.setState(mStateManager.getBattleState());
            }
        }
        if (mMonsterArray.size() == 0)
        {
            StateManager.setState(mStateManager.getEndState());
        }
    }

    @Override
    public void render(Graphics paintBrush) {
        mMap.render(paintBrush);
        mPlayerPiece.render(paintBrush);


        for (int x = 0; x < mMonsterArray.size(); x++){
            mMonsterArray.get(x).render(paintBrush);
        }

        for (int i = 0; i < itemList.size(); i++)
        {
            itemList.get(i).render(paintBrush);
        }

        Graphics2D twoDpaintBrush = (Graphics2D) paintBrush;
        paintBrush.setColor(Color.blue);
        if (mTime < 120 && runTime)
        {
            twoDpaintBrush.drawImage(GraphicAssets.mWood, 1000, 670, 400, 50, null);
            paintBrush.drawString(mEffectString, 1010, 695);
        }
    }

    public PlayerPiece getPlayer() {
        return mPlayerPiece;
    }

    public void setEffectString(String mEffectString) {
        this.mEffectString = mEffectString;
    }

    public void setRunTime(boolean runTime) {
        this.runTime = runTime;
    }
}
