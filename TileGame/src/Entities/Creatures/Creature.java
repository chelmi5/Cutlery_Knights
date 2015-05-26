package Entities.Creatures;
import Engine.Game;
import Entities.Entity;
import Map.Map;
import States.ExplorationState;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 50;
    public static final int DEFAULT_CREATURE_HEIGHT =  100;

    protected float mSpeed;
    protected float xMove;
    protected float yMove;

    // Colision Rectatangle
    private Rectangle mCollisionTangle;

    public Creature(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        mSpeed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        mCollisionTangle = new Rectangle(mWidth, mHeight);
    }

    public void move() {
        int numX = (int) (mX + xMove);
        int numY = (int) (mY + yMove);
        //if (!ExplorationState.isMoveable(numX, numY)) {
            mX += xMove;
            mY += yMove;
        //}
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(float mSpeed) {
        this.mSpeed = mSpeed;
    }

}
