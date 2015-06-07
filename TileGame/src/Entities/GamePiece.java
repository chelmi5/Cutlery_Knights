package Entities;
import Engine.Game;
import Graphics.GraphicAssets;
import Map.Map;

import java.awt.*;

public class GamePiece extends Creature {

    private int cordinateX = 0;
    private int cordinateY = 0;

    public GamePiece(Game game, float x, float y, Map mMap) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT, mMap);
    }

    @Override
    public void update() {
        getInput();
        move();
        cordinateX = (int)(mX);
        cordinateY = (int)(mY);

        mGame.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(mGame.getKeyManager().up)
            yMove = -mSpeed;
        if(mGame.getKeyManager().down)
            yMove = +mSpeed;
        if(mGame.getKeyManager().left)
            xMove = -mSpeed;
        if(mGame.getKeyManager().right)
            xMove =+ mSpeed;
    }

    @Override
    public void render(Graphics paintBrush) {
        paintBrush.drawImage(GraphicAssets.mPlayerIcon, (int) (mX - mGame.getGameCamera().getXoffset()), (int) (mY - mGame.getGameCamera().getYoffset()), mWidth, mHeight, null);
    }

    public int getCoordinateX() {
        return cordinateX;
    }

    public int getCoordinateY() {
        return cordinateY;
    }
}