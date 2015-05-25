package Entities.Creatures;
import Engine.Game;
import Entities.Entity;
import States.StateManager;
import Tile.Tile;
import Map.Map;
import java.awt.*;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 100;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 50;
    public static final int DEFAULT_CREATURE_HEIGHT =  100;

    protected int mHealth;
    protected float mSpeed;
    protected float xMove;
    protected float yMove;

    private Map mMap;

    // Colision Rectatangle
    private Rectangle mCollisionTangle;

    public Creature(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        mHealth = DEFAULT_HEALTH;
        mSpeed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        mCollisionTangle = new Rectangle(mWidth, mHeight);
    }

    public void move() {
        //if (!collision((int) xMove,0))
            mX += xMove;
        //if (!collision(0, (int)yMove))
            mY += yMove;
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

    public int getmHealth() {
        return mHealth;
    }

    public void setmHealth(int mHealth) {
        this.mHealth = mHealth;
    }

    public float getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(float mSpeed) {
        this.mSpeed = mSpeed;
    }

}
