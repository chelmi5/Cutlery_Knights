package Graphics;

import Engine.Game;
import Entities.GamePieces.PieceTemplate;

public class GameCamera {

    private float mXoffset;
    private float mYoffset;
    private Game mGame;

    public GameCamera (Game game, int xoffset, int yoffset) {
        mGame = game;
        mXoffset = xoffset;
        mYoffset = xoffset;
    }

    public void centerOnEntity(PieceTemplate character) {
        mXoffset = (int)character.getX() - mGame.getWidth() / 2 + character.getWidth()/2;
        mYoffset = (int)character.getY() - mGame.getHeight() / 2 + character.getHeight()/2;
    }

    public void move(float xMover, float yMover) {
        mXoffset += xMover;
        mYoffset += yMover;
    }

    public float getXoffset() {
        return mXoffset;
    }

    public void setXoffset(int mXoffset) {
        this.mXoffset = mXoffset;
    }

    public float getYoffset() {
        return mYoffset;
    }

    public void setYoffset(int mYoffset) {
        this.mYoffset = mYoffset;
    }
}
