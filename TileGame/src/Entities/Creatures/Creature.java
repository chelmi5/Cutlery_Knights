package Entities.Creatures;
import Entities.Entity;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 100;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 100;
    public static final int DEFAULT_CREATURE_HEIGHT =  200;

    protected int mHealth;
    protected float mSpeed;
    protected float xMove;
    protected float yMove;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        mHealth = DEFAULT_HEALTH;
        mSpeed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        mX += xMove;
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
