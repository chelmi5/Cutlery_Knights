package Entities.Creatures;
import Engine.Game;
import Entities.Entity;
import Map.Map;
import java.awt.*;

public abstract class Creature extends Entity {

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT =  64;

    protected float mSpeed;
    protected float xMove;
    protected float yMove;
    protected Map mMap;

    public Creature(Game game, float x, float y, int width, int height, Map map) {
        super(game, x, y, width, height);
        mMap = map;
        mSpeed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
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
    }

    protected boolean collision(int numX, int numY) {
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


    public float getxMove() {
        return xMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }

    public float getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(int mSpeed) {
        this.mSpeed = mSpeed;
    }

}
