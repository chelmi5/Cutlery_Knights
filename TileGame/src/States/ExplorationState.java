package States;
import java.awt.*;
import java.util.ArrayList;

import Engine.Game;
import Entities.AbstractHero;
import Entities.AbstractMonster;
import Entities.Creature;
import Entities.GamePiece;
import Entities.Mobs.*;
import Map.Map;
import Utilities.CodeTools;

public class ExplorationState implements State {

    private GamePiece mGamePiece;
    private Map mMap;
    private Game mGame;
    private StateManager mStateManager;
    private ArrayList<EnemyPiece> mMonsterArray = new ArrayList<EnemyPiece>();
    private static int enemyID = 1;

    public ExplorationState(Game game, StateManager stateManager) {
        mGame = game;
        mMap = mGame.getMap();
        mStateManager = stateManager;
        mGamePiece = new GamePiece(game, 100, 100, mMap);
        generateEnemies(mGame);
    }

    private void generateEnemies(Game game) {
        for(int x = 0; x < 4; x++) {
            int temp1 = 100 + CodeTools.randInt(20, 400);
            int temp2 = 100 + CodeTools.randInt(20, 400);
            while( colison(temp1, temp2))
            {
                temp1 = 100 + CodeTools.randInt(20, 400);
                temp2 = 100 + CodeTools.randInt(20, 400);
            }
                System.out.println("Check");
            AbstractMonster fish = new Fish(enemyID);
            mMonsterArray.add(new EnemyPiece(game, temp1, temp2, mMap, mGamePiece, fish));
            enemyID ++;
        }
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
        mGamePiece.update();
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
        mGamePiece.render(paintBrush);
        for (int x = 0; x < mMonsterArray.size(); x++){
            mMonsterArray.get(x).render(paintBrush);
        }
    }

    public GamePiece getPlayer() {
        return mGamePiece;
    }
}
