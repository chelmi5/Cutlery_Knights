package Entities;
import Engine.Game;
import java.awt.*;

public abstract class Entity {

        protected float mX, mY;
        protected int mWidth;
        protected int mHeight;
        protected Game mGame;

    public Entity(Game game, float x, float y, int width, int height){
            mX = x;
            mY = y;
            mWidth = width;
            mHeight = height;
            mGame = game;
        }

    public abstract void update();
    public abstract void render(Graphics g);

    public float getX() {
        return mX;
    }

    public void setX(float mX) {
        this.mX = mX;
    }

    public float getY() {
        return mY;
    }

    public void setY(float mY) {
        this.mY = mY;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

}