package Entities.GamePieces;
import Engine.Game;
import Map.Map;

import java.awt.*;

public abstract class PieceTemplate {

    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT =  64;

    protected float mX, mY;
    protected int mWidth;
    protected int mHeight;
    protected Game mGame;

    protected float mSpeed;
    protected float xMove;
    protected float yMove;
    protected Map mMap;

    public PieceTemplate(Game game, float x, float y, int width, int height, Map map) {
        mGame = game;
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
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

    public boolean isFight() {
        return false;
    }

    public abstract void update();
    public abstract void render(Graphics g);

    public float getX() {
        return mX;
    }

    public void setX(int mX) {
        this.mX = mX;
    }

    public float getY() {
        return mY;
    }

    public void setY(int mY) {
        this.mY = mY;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

}
