package Entities.GamePieces;
import Engine.Game;
import Map.Map;
import Entities.Mobs.Mob;
import java.awt.*;

import Utilities.CodeTools;

public class EnemyPieceTemplate extends PieceTemplate {

    private int mTime = 0;
    private int mRandomNumber1 = 0;
    private int mRandomNumber2 = 0;
    private PlayerPieceTemplate mPlayerPiece;
    private Mob mMonster;
    private boolean fight = false;
    private int mEnemyID;

    public EnemyPieceTemplate(Game game, float x, float y, Map map, PlayerPieceTemplate playerPiece, Mob monster) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_WIDTH, map);
        mMonster = monster;
        mPlayerPiece = playerPiece;
        mMonster.getEnemyID();
        mEnemyID = mMonster.getEnemyID();
    }

    public void update() {
        wonder();
        move();
    }

    private void wonder() {
        mTime++;
        if (mTime == 60) {
            mRandomNumber1 = CodeTools.randInt(1, 4);
            mRandomNumber2 = CodeTools.randInt(1, 4);
            mTime = 0;
        }

        xMove = 0;
        yMove = 0;
        int minus = 2;

        if (mRandomNumber1 == 1 || mRandomNumber2 == 1)
            yMove = +mSpeed - minus;
        if(mRandomNumber1 == 2 || mRandomNumber2 == 2)
            yMove = -mSpeed + minus;
        if(mRandomNumber1 == 3 || mRandomNumber2 == 3)
            xMove = -mSpeed + minus;
        if(mRandomNumber1 == 4 || mRandomNumber2 == 4)
            xMove =+mSpeed - minus;
    }

    public void move() {

        int numX = (int) (mX + xMove);
        int numY = (int) (mY + yMove);

        if (!collision(numX, (int)mY)) {
            mX += xMove;
        }
        if (!collision((int)mX, numY)) {
            mY += yMove;
        }

        //System.out.println("x: "+ mPlayerPiece.getCoordinateX() + "y: " + mPlayerPiece.getCoordinateY());
        //System.out.println("yMove: " + numY);

        int rangeHighX = (numX + 50);
        int rangeLowX = (numX - 10);
        int rangeHighY = (numY + 10);
        int rangeLowY = (numY - 60);


        if ((mPlayerPiece.getCoordinateX() < rangeHighX && mPlayerPiece.getCoordinateX() > rangeLowX) &&
                (mPlayerPiece.getCoordinateY() < rangeHighY && mPlayerPiece.getCoordinateY() > rangeLowY))
        {
            mGame.setAttackingEnemyID(mEnemyID);
            fight = true;
            System.out.println("Switching to BattleState");
        }
    }

    public void render(Graphics paintBrush) {
        paintBrush.drawImage(mMonster.getIcon(),(int)(mX -  mGame.getGameCamera().getXoffset()), (int)(mY -  mGame.getGameCamera().getYoffset()), mWidth, mHeight, null);
    }

    public Mob getMonster() {
        return mMonster;
    }

    public void setEnemyID() {
        mEnemyID--;
    }

    public boolean isFight() {
        return fight;
    }
}
