package Entities;
import java.awt.*;

public abstract class Entity {

        protected float mX, mY;
        protected int mWidth;
        protected int mHeight;

    public Entity(float x, float y, int width, int height){
            mX = x;
            mY = y;
            mWidth = width;
            mHeight = height;

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
