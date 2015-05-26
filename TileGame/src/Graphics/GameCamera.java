package Graphics;

import Engine.Game;
import Entities.Entity;

public class GameCamera {

    private float mXoffset;
    private float mYoffset;
    private Game mGame;

    public GameCamera (Game game, float xoffset, float yoffset) {
        mGame = game;
        mXoffset = xoffset;
        mYoffset = xoffset;
    }

    public void centerOnEntity(Entity character) {
        mXoffset = character.getX() - mGame.getWidth() / 2 + character.getWidth()/2;
        mYoffset = character.getY() - mGame.getHeight() / 2 + character.getHeight()/2;
    }

    public void move(float xMover, float yMover) {
        mXoffset += xMover;
        mYoffset += yMover;
    }

    public float getXoffset() {
        return mXoffset;
    }

    public void setXoffset(float mXoffset) {
        this.mXoffset = mXoffset;
    }

    public float getYoffset() {
        return mYoffset;
    }

    public void setYoffset(float mYoffset) {
        this.mYoffset = mYoffset;
    }
}
