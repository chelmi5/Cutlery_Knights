package States;
import java.awt.*;
import java.util.ArrayList;

import Engine.Game;
import Entities.GamePieces.EnemyPieceTemplate;
import Entities.GamePieces.PlayerPieceTemplate;
import Entities.Mobs.*;
import Map.Map;
import Utilities.CodeTools;

public class ExplorationState implements State {

    private PlayerPieceTemplate mPlayerPiece;
    private Map mMap;
    private Game mGame;
    private StateManager mStateManager;
    private ArrayList<EnemyPieceTemplate> mMonsterArray = new ArrayList<EnemyPieceTemplate>();
    private int enemyID = 0;

    public ExplorationState(Game game, StateManager stateManager) {
        mGame = game;
        mMap = mGame.getMap();
        mStateManager = stateManager;
        mPlayerPiece = new PlayerPieceTemplate(game, 100, 100, mMap);
        generateEnemies(mGame);
    }

    private void generateEnemies(Game game) {
        RoundOneFactory mobFactory = new RoundOneFactory();

        for(int x = 0; x < 4; x++) {

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

            int temp1 = 100 + CodeTools.randInt(20, 400);
            int temp2 = 100 + CodeTools.randInt(20, 400);
            while( colison(temp1, temp2))
            {
                temp1 = 100 + CodeTools.randInt(20, 400);
                temp2 = 100 + CodeTools.randInt(20, 400);
            }
                System.out.println("Check");

            Mob newMob = mobFactory.makeMob(mobString, enemyID);
            mMonsterArray.add(new EnemyPieceTemplate(game, temp1, temp2, mMap, mPlayerPiece, newMob));
            enemyID ++;
        }
        mGame.setmOriginalSize(mMonsterArray.size());
        mGame.setMonsterArray(mMonsterArray);
    }

    private boolean colison(int numX, int numY) {
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
    }

    public PlayerPieceTemplate getPlayer() {
        return mPlayerPiece;
    }
}
